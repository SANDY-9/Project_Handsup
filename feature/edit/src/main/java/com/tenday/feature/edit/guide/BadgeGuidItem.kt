package com.tenday.feature.edit.guide

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.svgImageLoader
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun BadgeGuidItem(
    badge: BadgeCode,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = Dimens.margin10),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = modifier.fillMaxWidth(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = modifier.size(56.dp),
                painter = svgImageLoader(badge.resFilePath),
                contentDescription = null,
            )
            Spacer(modifier = modifier.height(Dimens.margin4))
            Text(
                text = badge.badgeName,
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
            )
        }
        Spacer(modifier = modifier.width(Dimens.margin6))
        Text(
            modifier = modifier.fillMaxWidth().padding(vertical = Dimens.margin27),
            text = badge.desc,
            style = HandsUpTypography.body2.copy(
                color = Gray700,
            ),
            maxLines = 2,
            overflow = TextOverflow.Visible,
        )
    }
}

@Preview(name = "BadgeGuidItem")
@Composable
private fun PreviewBadgeGuidItem() {
    BadgeGuidItem(BadgeCode.S_GRADE_H1_H2)
}