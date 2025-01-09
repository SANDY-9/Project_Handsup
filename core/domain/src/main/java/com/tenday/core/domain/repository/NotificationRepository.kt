package com.tenday.core.domain.repository

import com.tenday.core.model.NotificationDetails

interface NotificationRepository {
    suspend fun getNotificationList(token: String): List<NotificationDetails>
}