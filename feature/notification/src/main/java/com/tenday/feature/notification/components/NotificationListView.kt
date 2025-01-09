package com.tenday.feature.notification.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tenday.core.model.NotificationDetails

@Composable
internal fun NotificationListView(
    items: List<NotificationDetails>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(items) { notificationDetails ->
            NotificationListItem(notificationDetails)
        }
    }
}

