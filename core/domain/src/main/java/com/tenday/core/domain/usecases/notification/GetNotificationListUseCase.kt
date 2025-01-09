package com.tenday.core.domain.usecases.notification

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.NotificationRepository
import com.tenday.core.model.NotificationDetails
import javax.inject.Inject

class GetNotificationListUseCase @Inject constructor(
    private val notificationRepository: NotificationRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(): List<NotificationDetails> {
        val accessToken = authPrefsRepository.getAccessToken() ?: ""
        return notificationRepository.getNotificationList(accessToken)
    }
}