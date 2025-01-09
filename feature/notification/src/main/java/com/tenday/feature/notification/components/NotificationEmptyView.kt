package com.tenday.feature.notification.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Alarm
import com.tenday.designsystem.theme.Gray200
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.notification.R

@Composable
internal fun NotificationEmptyView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = modifier.fillMaxHeight(0.25f))
        Icon(
            modifier = modifier.size(74.dp),
            imageVector = Icons.Alarm,
            contentDescription = null,
            tint = Gray200,
        )
        Spacer(modifier = modifier.height(Dimens.margin20))
        Text(
            text = stringResource(R.string.notify_empty_title),
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            text = stringResource(R.string.notify_empty_desc),
            textAlign = TextAlign.Center,
            style = HandsUpTypography.body2,
            color = Gray600,
        )

    }
}

@Preview(name = "NotificationEmptyView")
@Composable
private fun PreviewNotificationEmptyView() {
    NotificationEmptyView()
}