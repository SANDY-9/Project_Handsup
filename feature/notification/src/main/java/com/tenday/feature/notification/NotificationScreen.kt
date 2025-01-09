package com.tenday.feature.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.theme.White
import com.tenday.feature.notification.components.NotificationEmptyView
import com.tenday.feature.notification.components.NotificationListView
import com.tenday.feature.notification.components.NotificationTitleBar
import com.tenday.feature.notification.model.NotificationUiState

@Composable
internal fun NotificationRoute(
    onNavigateBack: () -> Unit,
    viewModel: NotificationViewModel = hiltViewModel()
) {
    val notifyUiState by viewModel.notifyUiState.collectAsStateWithLifecycle()
    NotificationScreen(
        uiState = notifyUiState,
        onNavigateBack = onNavigateBack,
    )
}

@Composable
internal fun NotificationScreen(
    uiState: NotificationUiState,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = White)
    ) {
        NotificationTitleBar(onNavigate = onNavigateBack)
        when(uiState) {
            is NotificationUiState.EmptyItem -> NotificationEmptyView()
            is NotificationUiState.Success -> NotificationListView(uiState.data)
            else -> { }
        }
    }
}

@Preview(name = "NotificationScreen")
@Composable
private fun PreviewNotificationScreen() {
    NotificationScreen(NotificationUiState.EmptyItem, {})
}