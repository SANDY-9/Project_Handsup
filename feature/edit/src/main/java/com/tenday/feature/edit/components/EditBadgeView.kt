package com.tenday.feature.edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.extentions.svgImageLoader
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
    badgeList: List<BadgeCode>,
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
                ) {
                    Row(
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
                    LazyVerticalGrid(
                        modifier = modifier.height(225.dp),
                        columns = GridCells.Fixed(3),
                        verticalArrangement = Arrangement.spacedBy(Dimens.margin6),
                    ) {
                        items(badgeList) { badge ->
                            if(badge != BadgeCode.NULL) {
                                ProfileBadgeItem(
                                    modifier = modifier.weight(1f),
                                    select = badge == currentBadge,
                                    badge = badge,
                                    onItemClick = { onBadgeClick(badge) }
                                )
                            }
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
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.noRippleClickable(onClick = onItemClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = svgImageLoader(
                if(select) badge.resFilePath
                else badge.offResFilePath
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
            text = "24.05.28",
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
        BadgeCode.list(),
        {},
        {},
    )
}