package com.tenday.network.model


import com.tenday.core.model.NotificationDetails
import kotlinx.serialization.Serializable

@Serializable
data class NotificationResponse(
    val noticeList: List<NotificationDetails>
)