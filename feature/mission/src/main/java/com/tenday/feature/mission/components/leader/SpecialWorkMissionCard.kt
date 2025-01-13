package com.tenday.feature.mission.components.leader

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.tenday.designsystem.components.HandsUpTextureCard
import com.tenday.designsystem.components.HandsUpThreeSpaceTable
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.LinearGradientBlue
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionToolTipTitle

@Composable
internal fun SpecialWorkMissionCard(
    jobFamily: String,
    jobGroup: Int,
    visibleTable: Boolean,
    onShowSpecialTooltip: (IntOffset) -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpTextureCard(
        gradient = LinearGradientBlue,
    ) {
        MissionToolTipTitle(
            jobFamily = jobFamily,
            jobGroup = jobGroup,
            onShowTooltip = onShowSpecialTooltip,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        Text(
            text = stringResource(R.string.mission_leader_special_title),
            style = HandsUpTypography.title3.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = stringResource(R.string.mission_leader_special_desc),
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        AnimatedVisibility(visibleTable) {
            Column {
                Spacer(modifier = modifier.height(Dimens.margin12))
                HandsUpThreeSpaceTable(
                    title1 = stringResource(R.string.mission_content_term_title),
                    content1 = "주간 미션",
                    title2 = stringResource(R.string.mission_content_max_title),
                    content2 = "개선 리드",
                    title3 = stringResource(R.string.mission_content_median_title),
                    content3 = "개선 참여",
                )
            }
        }
    }
}

@Preview(name = "SpecialWorkMissionCard")
@Composable
private fun PreviewSpecialWorkMissionCard() {
    SpecialWorkMissionCard("음성 1센터", 1, false, {})
}