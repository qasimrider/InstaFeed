package com.test.instafeed.utils

import android.content.Context
import coil3.request.CachePolicy
import coil3.request.ImageRequest


fun imageRequest(context: Context, imgRes: Int): ImageRequest =
    ImageRequest.Builder(context)
        .data(imgRes)
        .memoryCacheKey(imgRes.toString())
        .diskCacheKey(imgRes.toString())
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()
