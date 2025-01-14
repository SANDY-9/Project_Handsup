package com.tenday.feature.notification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.model.NotificationDetails
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.AlarmFill
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpOrangeSub
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.notification.R

@Composable
internal fun NotificationListItem(
    noti: NotificationDetails,
    modifier: Modifier = Modifier
) {
    Column {
        Spacer(modifier = modifier.height(Dimens.margin16))
        Row(
            modifier = modifier.padding(horizontal = Dimens.margin20),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = modifier.size(24.dp).background(
                    color = HandsUpOrangeSub,
                    shape = CircleShape,
                ).padding(Dimens.margin4),
                imageVector = Icons.AlarmFill,
                contentDescription = null,
                tint = HandsUpOrange,
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Text(
                text = stringResource(R.string.notify_title),
                style = HandsUpTypography.body3.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = HandsUpOrange
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = noti.createdAt,
                style = HandsUpTypography.body3,
                color = Gray500,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin10))
        Text(
            modifier = modifier.padding(horizontal = Dimens.margin20),
            text = noti.title,
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.Bold,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            modifier = modifier.padding(horizontal = Dimens.margin20),
            text = noti.body,
            style = HandsUpTypography.body3,
            color = Gray700
        )
        Spacer(modifier = modifier.height(Dimens.margin20))
        HorizontalDivider(color = Gray100)
    }
}

@Preview(name = "NotificationListItem")
@Composable
private fun PreviewNotificationListItem() {
    NotificationListItem(
        NotificationDetails(
            "두둥 경험치를 획득하였습니다. 다음 미션도 도전하세요!",
            "3일 전",
            "축하합니다! 새로운 두둥 경험치를 받았어요!"
        )
    )
}