package com.tenday.feature.exp.lovelguide

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.HandsUpLevel
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.svgImageLoader
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpOrangeSub
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
internal fun LevelGuidItem(
    level: HandsUpLevel,
    isMatchedLevel: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if(isMatchedLevel) HandsUpOrangeSub else White,
            ).padding(
                start = Dimens.margin16,
                end = Dimens.margin12,
                top = Dimens.margin16,
                bottom = Dimens.margin16
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row (
            modifier = modifier.fillMaxWidth(0.3f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = modifier.size(32.dp),
                    painter = svgImageLoader(level.resPath),
                    contentDescription = null,
                )
                Spacer(modifier = modifier.width(Dimens.margin4))
                Text(
                    modifier = modifier.background(
                        color = if(isMatchedLevel) HandsUpOrange else White,
                        shape = RoundedCornerShape(Dimens.cornerShape4),
                    ).padding(
                        horizontal = Dimens.margin6,
                        vertical = Dimens.margin2,
                    ),
                    text = level.desc,
                    style = HandsUpTypography.body3.copy(
                        fontWeight = FontWeight.Bold,
                        color = if(isMatchedLevel) White else Gray900,
                    ),
                )
            }
        }
        Spacer(modifier = modifier.width(Dimens.margin6))
        Text(
            modifier = modifier.fillMaxWidth(),
            text = level.exp.toData() + "do",
            style = HandsUpTypography.body2.copy(
                fontWeight = if(isMatchedLevel) FontWeight.Bold else FontWeight.SemiBold,
                color = if(isMatchedLevel) HandsUpOrange else Gray900,
            ),
            textAlign = TextAlign.End,
        )
    }
}

@Preview(name = "BadgeGuidItem")
@Composable
private fun PreviewBadgeGuidItem() {
    LevelGuidItem(HandsUpLevel.F4_I, false)
}