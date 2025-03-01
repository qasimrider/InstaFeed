package com.test.instafeed.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.instafeed.R
import com.test.instafeed.ui.model.FeedItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    // State to hold the list of feed items
    private val _feedItems = MutableStateFlow<FeedScreenUiState>(FeedScreenUiState.Loading)
    val feedItems = _feedItems.asStateFlow()

    init {
        // Load feed items (In a real app, you may fetch this data from an API or local database)
        loadFeedItems()
    }

    private fun loadFeedItems() {
        //this is loading the data locally it can call the network Api from this point onwards
        viewModelScope.launch {
            val feedItems = listOf(
                FeedItem(
                    imageRes = R.drawable.image1,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = R.drawable.image8,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video1,
                    description = "This is the awesome feed of Insta2"
                ),
                FeedItem(
                    imageRes = R.drawable.image7,
                    videoRes = R.raw.video2,
                    description = "This is the awesome feed of Insta10"
                ),
                FeedItem(
                    imageRes = R.drawable.image5,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video2,
                    description = "This is the awesome feed of Insta3"
                ),
                FeedItem(
                    imageRes = R.drawable.image3,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video3,
                    description = "This is the awesome feed of Insta4"
                ),
                FeedItem(
                    imageRes = R.drawable.image2,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video4,
                    description = "This is the awesome feed of Insta5"
                ),
                FeedItem(
                    imageRes = R.drawable.image10,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video5,
                    description = "This is the awesome feed of Insta6"
                ),
                FeedItem(
                    imageRes = R.drawable.image6,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video1,
                    description = "This is the awesome feed of Insta7"
                ),
                FeedItem(
                    imageRes = R.drawable.image4,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video2,
                    description = "This is the awesome feed of Insta8"
                ),
                FeedItem(
                    imageRes = R.drawable.image3,
                    videoRes = null,
                    description = "This is the awesome feed of Insta"
                ),
                FeedItem(
                    imageRes = null,
                    videoRes = R.raw.video3,
                    description = "This is the awesome feed of Insta9"
                ),
                FeedItem(
                    imageRes = R.drawable.image7,
                    videoRes = R.raw.video2,
                    description = "This is the awesome feed of Insta10"
                ),
                FeedItem(
                    imageRes = R.drawable.image9,
                    videoRes = null,
                    description = "This is the awesome feed of Insta 1098"
                ),
            )

            _feedItems.update { FeedScreenUiState.Success(feedItems) }
        }
    }
}

sealed interface FeedScreenUiState {
    data class Success(val feedItems: List<FeedItem>) : FeedScreenUiState
    data object Loading : FeedScreenUiState
}
