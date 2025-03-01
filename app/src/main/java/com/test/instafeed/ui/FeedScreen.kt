package com.test.instafeed.ui

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil3.compose.AsyncImage
import com.test.instafeed.R
import com.test.instafeed.ui.model.FeedItem

@Composable
fun FeedScreen(modifier: Modifier = Modifier, feedViewModel: FeedViewModel = viewModel()) {

    val feedItems = remember { mutableStateListOf<FeedItem>() }
    val listState = rememberLazyListState()

    val uiState by feedViewModel.feedItems.collectAsStateWithLifecycle()

    when (uiState) {
        is FeedScreenUiState.Success -> {
            feedItems.clear()
            feedItems.addAll((uiState as FeedScreenUiState.Success).feedItems)
        }

        FeedScreenUiState.Loading -> { /* Progress loader here */
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = listState
    ) {
        items(
            count = feedItems.size,
            key = { index -> feedItems[index].id }) { index ->
            FeedItemView(feedItems[index], listState, index)
        }
    }
}


@Composable
private fun FeedItemView(feedItem: FeedItem, listState: LazyListState, index: Int) {
    val configuration = LocalConfiguration.current
    val imageHeight = configuration.screenHeightDp / 1.5

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        feedItem.videoRes?.let {
            VideoPlayer(videoRes = it, listState, index)
        }
        if (feedItem.videoRes != null && feedItem.imageRes != null) {
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(10.dp))
        }
        feedItem.imageRes?.let {
            AsyncImage(
                model = it,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight.dp)
            )
        }
        FeedActions()
        Text(
            text = feedItem.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun FeedActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Like")
            }
            Text(text = "9,898", style = MaterialTheme.typography.bodyMedium)
            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.comment), contentDescription = "Comment")
            }
            Text(text = "45", style = MaterialTheme.typography.bodyMedium)
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
            }
            Text(text = "310", style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(onClick = {}) {
            Icon(painterResource(R.drawable.bookmark), contentDescription = "Bookmark")
        }
    }
}


@Composable
fun VideoPlayer(videoRes: Int, listState: LazyListState, index: Int) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val videoPlayerHeight = configuration.screenHeightDp / 1.5

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse("android.resource://${context.packageName}/$videoRes")))
            prepare()
        }
    }

    val isVisible = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val startOffset = layoutInfo.viewportStartOffset
            val endOffset = layoutInfo.viewportEndOffset

            // Calculate if the feed item's position is within the visible viewport
            val itemIndex = index
            val firstVisibleItem = layoutInfo.visibleItemsInfo.firstOrNull { it.index == itemIndex }
            Log.i(
                "Feed",
                "videoRes $videoRes startOffset $startOffset endOffset $endOffset visibleItemOffset ${firstVisibleItem?.offset}"
            )
            val firstVisibleItemOffset = firstVisibleItem?.offset?.plus(500)
            firstVisibleItemOffset != null && firstVisibleItemOffset in startOffset..endOffset
        }
    }

    DisposableEffect(Unit) { onDispose { exoPlayer.release() } }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(videoPlayerHeight.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                PlayerView(it).apply { player = exoPlayer }
            },
            update = { if (isVisible.value) exoPlayer.play() else exoPlayer.pause() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}
