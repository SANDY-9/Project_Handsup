package com.tenday.feature.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.theme.White
import com.tenday.feature.notification.components.NotificationContentView
import com.tenday.feature.notification.components.NotificationTitleBar

@Composable
internal fun NotificationScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = White)
    ) {
        NotificationTitleBar(onNavigate = onNavigateBack)
        NotificationContentView()
    }
}

@Preview(name = "NotificationScreen")
@Composable
private fun PreviewNotificationScreen() {
    NotificationScreen({})
}