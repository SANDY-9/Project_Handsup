package com.tenday.core.model


import kotlinx.serialization.Serializable

@Serializable
data class NotificationDetails(
    val body: String,
    val createdAt: String,
    val title: String,
)