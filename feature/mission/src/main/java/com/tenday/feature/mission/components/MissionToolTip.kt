package com.tenday.feature.mission.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpToolTip
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.CheckMax
import com.tenday.designsystem.icons.CheckMedium
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R

@Composable
internal fun MissionToolTip(
    missionName: String = "생산성 향상",
    maxPoint: Int = 80,
    minPoint: Int = 40,
    width: Dp = 211.dp,
    modifier: Modifier = Modifier,
) {
    HandsUpToolTip(
        modifier = modifier.width(width),
    ) {
        Text(
            text = "$missionName " +
                    stringResource(R.string.mission_tool_tip_desc1),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            )

        )
        Spacer(modifier = modifier.height(Dimens.margin2))
        Text(
            text = stringResource(R.string.mission_tool_tip_desc2),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            )
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = modifier.size(16.dp),
                imageVector = Icons.CheckMax,
                contentDescription = null,
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Text(
                text = stringResource(R.string.mission_tool_tip_desc_max),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.Medium,
                    color = White,
                )
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "$maxPoint",
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin2))
            Image(
                modifier = modifier.size(12.dp),
                imageVector = Icons.Dodoong,
                contentDescription = null,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin6))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = modifier.size(16.dp),
                imageVector = Icons.CheckMedium,
                contentDescription = null,
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Text(
                text = stringResource(R.string.mission_tool_tip_desc_medium),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.Medium,
                    color = White,
                )
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "$minPoint",
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin2))
            Image(
                modifier = modifier.size(12.dp),
                imageVector = Icons.Dodoong,
                contentDescription = null,
            )
        }
    }
}

@Preview(name = "MissionToolTop")
@Composable
private fun PreviewMissionToolTop() {
    MissionToolTip()
}