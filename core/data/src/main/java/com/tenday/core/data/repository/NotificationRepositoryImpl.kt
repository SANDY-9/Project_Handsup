package com.tenday.core.data.repository

import com.tenday.core.domain.repository.NotificationRepository
import com.tenday.core.model.NotificationDetails
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class NotificationRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource
): NotificationRepository {
    override suspend fun getNotificationList(token: String): List<NotificationDetails> {
        return handsUpDataSource.getNotificationList(token)
    }
}