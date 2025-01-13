package com.tenday.feature.mission.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.icons.Info
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.TransparentBlack16
import com.tenday.designsystem.theme.TransparentWhite80
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R

@Composable
internal fun MissionToolTipTitle(
    jobFamily: String,
    jobGroup: Int,
    onShowTooltip: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        JopFamilyBadge(jobFamily, jobGroup)
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = stringResource(R.string.mission_tool_tip_title),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        Spacer(modifier = modifier.width(Dimens.margin4))
        Icon(
            modifier = modifier.noRippleClickable(onClick = onShowTooltip),
            imageVector = Icons.Info,
            contentDescription = null,
            tint = White,
        )
    }
}

@Composable
private fun JopFamilyBadge(
  jobFamily: String,
  jobGroup: Int,
  modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = TransparentBlack16,
                shape = RoundedCornerShape(Dimens.cornerShape4),
            )
            .padding(
                vertical = Dimens.margin2,
                horizontal = Dimens.margin6,
            )
    ) {
        Text(
            text = "${jobFamily} · ${jobGroup}그룹",
            style = HandsUpTypography.body4.copy(
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = TransparentWhite80,
            )
        )
    }
}


@Composable
@Preview
private fun Preview() {
    Box(
        modifier = Modifier
            .background(color = Color.Gray)
            .padding(10.dp)
    ) {
        MissionToolTipTitle("음성 1센터", 1, {},)
    }
}