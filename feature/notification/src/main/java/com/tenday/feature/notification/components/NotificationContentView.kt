package com.tenday.feature.notification.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun NotificationContentView(
    modifier: Modifier = Modifier
) {
    //NotificationEmptyView()
    LazyColumn {
        items(20) {
            NotificationListItem()
        }
    }
}


@Preview(name = "NotificationContentView")
@Composable
private fun PreviewNotificationContentView() {
    NotificationContentView()
}