package com.tenday.feature.notification.model

import com.tenday.core.model.NotificationDetails

internal sealed interface NotificationUiState {
    data object Loading: NotificationUiState
    data class Success(val data: List<NotificationDetails>): NotificationUiState
    data object Fail: NotificationUiState
    data object EmptyItem: NotificationUiState
}