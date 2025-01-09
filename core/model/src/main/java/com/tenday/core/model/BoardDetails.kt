package com.tenday.core.model

import kotlinx.serialization.Serializable


@Serializable
data class BoardDetails(
    val boardId: Int,
    val content: String,
    val createdAt: String,
    val title: String,
    val isRead: Boolean,
): java.io.Serializable