package com.test.instafeed.ui.model

import androidx.compose.runtime.Immutable
import java.util.UUID

@Immutable
data class FeedItem(
    val id: String = UUID.randomUUID().toString(),
    val imageRes: Int?,
    val videoRes: Int?,
    val description: String
)