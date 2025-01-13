package com.tenday.feature.mission.components.job

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.tenday.designsystem.theme.LinearGradientSunRise
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionToolTipTitle

@Composable
internal fun JobMissionCard(
    jobFamily: String,
    jobGroup: Int,
    onShowTooltip: (IntOffset) -> Unit,
    visibleTable: Boolean = true,
    modifier: Modifier = Modifier,
) {
    HandsUpTextureCard(
        modifier = modifier.fillMaxWidth(),
        gradient = LinearGradientSunRise,
    ) {
        MissionToolTipTitle(
            jobFamily = jobFamily,
            jobGroup = jobGroup,
            onShowTooltip = onShowTooltip,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        Text(
            text = "생산성향상",
            style = HandsUpTypography.title3.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = stringResource(R.string.mission_job_goal) + "",
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

@Preview(name = "JobMissionCard")
@Composable
private fun PreviewJobMissionCard() {
    JobMissionCard("음성 1센터", 1, {})
}