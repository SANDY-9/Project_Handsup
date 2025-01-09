package com.tenday.feature.notification.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpNavigateTopBar
import com.tenday.designsystem.theme.Gray200
import com.tenday.feature.notification.R

@Composable
internal fun NotificationTitleBar(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        HandsUpNavigateTopBar(
            title = stringResource(R.string.notify_title),
            onNavigate = onNavigate
        )
        HorizontalDivider(color = Gray200)
    }
}

@Preview(name = "NotificationTitleTopBar")
@Composable
private fun PreviewNotificationTitleTopBar() {
    NotificationTitleBar({})
}