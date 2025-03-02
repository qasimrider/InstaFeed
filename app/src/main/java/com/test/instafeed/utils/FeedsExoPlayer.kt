package com.test.instafeed.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.FileDataSource
import androidx.media3.datasource.cache.Cache
import androidx.media3.datasource.cache.CacheDataSink
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import java.io.File

class FeedsExoPlayer(private val context: Context) : Player.Listener {

    private var player: ExoPlayer? = null

    @UnstableApi
    fun build(videoRes: Int): FeedsExoPlayer {

        if (player == null) {
            player = ExoPlayer.Builder(context).build().apply {
                playWhenReady = true
                addListener(this@FeedsExoPlayer)
            }
        }

        val mediaItem = createMediaItem(videoRes)
        val mediaSource = createMediaSource(mediaItem)

        player?.apply {
            setMediaSource(mediaSource)
            prepare()
        }
        return this
    }

    fun get() = player

    fun releasePlayer() {
        player?.release()
    }

    fun play() {
        player?.play()
    }

    fun pause() {
        player?.pause()
    }

    @OptIn(UnstableApi::class)
    private fun buildCacheDataSourceFactory(context: Context): DataSource.Factory {
        val cache = VideoCache.getCache(context)
        Log.d("CacheTest", "ExoPlayer Cache size: ${cache.cacheSpace} bytes")

        val cacheSink = CacheDataSink.Factory()
            .setCache(cache)
        val upstreamFactory = DefaultDataSource.Factory(context)
        return CacheDataSource.Factory()
            .setCache(cache)
            .setCacheWriteDataSinkFactory(cacheSink)
            .setCacheReadDataSourceFactory(FileDataSource.Factory())
            .setUpstreamDataSourceFactory(upstreamFactory)
            .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)
    }

    private fun createMediaItem(videoRes: Int): MediaItem =
        MediaItem.fromUri(Uri.parse("android.resource://${context.packageName}/$videoRes"))

    @UnstableApi
    private fun createMediaSource(mediaItem: MediaItem): ProgressiveMediaSource =
        ProgressiveMediaSource.Factory(buildCacheDataSourceFactory(context))
            .createMediaSource(mediaItem)
}

@UnstableApi
object VideoCache {
    private var simpleCache: SimpleCache? = null

    @Synchronized
    fun getCache(context: Context): Cache {
        return simpleCache ?: synchronized(this) {
            val cacheDir = File(context.cacheDir, "video_cache")
            val evictor = LeastRecentlyUsedCacheEvictor(100 * 1024 * 1024) // 100MB cache size
            val databaseProvider = StandaloneDatabaseProvider(context)

            SimpleCache(cacheDir, evictor, databaseProvider).also { simpleCache = it }
        }
    }
}
