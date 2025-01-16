package com.tenday.feature.edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.model.Badge
import com.tenday.core.resources.offResources
import com.tenday.core.resources.resources
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.icons.Info
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.edit.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EditBadgeView(
    currentBadge: BadgeCode,
    badgeList: List<Badge>,
    onShowBadgeInfo: () -> Unit,
    onBadgeClick: (BadgeCode) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(
            top = Dimens.margin20,
            start = Dimens.margin20,
            end = Dimens.margin20,
        )
    ) {
        HandsUpShadowCard(
            shadowColor = CardShadowLight,
            offsetY = 2.dp,
            content = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(Dimens.margin20),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = stringResource(R.string.edit_badge_title),
                            style = HandsUpTypography.title5,
                        )
                        Spacer(modifier = modifier.width(Dimens.margin4))
                        Icon(
                            modifier = modifier
                                .size(16.dp)
                                .noRippleClickable(onClick = onShowBadgeInfo)
                            ,
                            imageVector = Icons.Info,
                            contentDescription = null,
                            tint = Gray700,
                        )
                    }
                    Spacer(modifier = modifier.height(Dimens.margin12))
                    FlowRow(
                        modifier = modifier.fillMaxWidth(),
                        maxItemsInEachRow = 3,
                        horizontalArrangement = Arrangement.Start,
                        verticalArrangement = Arrangement.spacedBy(
                            Dimens.margin6,
                            Alignment.CenterVertically
                        )
                    ) {
                        badgeList.forEach { badge ->
                            ProfileBadgeItem(
                                modifier = modifier.fillMaxWidth(0.33f),
                                select = badge.badgeCode == currentBadge,
                                badge = badge.badgeCode,
                                date = badge.createdAt,
                                onItemClick = { onBadgeClick(badge.badgeCode) },
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
private fun ProfileBadgeItem(
    select: Boolean,
    badge: BadgeCode,
    onItemClick: () -> Unit,
    date: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.noRippleClickable(onClick = onItemClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = painterResource(
                if(select) badge.resources()
                else badge.offResources()
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(Dimens.margin8))
        Text(
            text = badge.badgeName,
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
        Spacer(modifier = Modifier.height(Dimens.margin2))
        Text(
            text = date.substring(2),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.Medium,
                color = Gray600,
            ),
        )
    }
}

@Preview(name = "EditBadgeView")
@Composable
private fun PreviewEditBadgeView() {
    EditBadgeView(
        BadgeCode.JOB_EXP_OVER_1700,
        BadgeCode.list().map {
            Badge(
                badgeCode = it,
                createdAt = "2024.05.28"
            )
        },
        {},
        {},
    )
}