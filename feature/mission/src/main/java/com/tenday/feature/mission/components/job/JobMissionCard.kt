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
import com.tenday.core.common.enums.MissionPeriod
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
    department: String,
    jobGroup: Int,
    missionName: String,
    missionGoal: String,
    period: MissionPeriod,
    maxCondition: String,
    medianCondition: String,
    onShowTooltip: (IntOffset) -> Unit,
    visibleTable: Boolean = true,
    modifier: Modifier = Modifier,
) {
    HandsUpTextureCard(
        modifier = modifier.fillMaxWidth(),
        gradient = LinearGradientSunRise,
    ) {
        MissionToolTipTitle(
            jobFamily = department,
            jobGroup = jobGroup,
            onShowTooltip = onShowTooltip,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        Text(
            text = missionName,
            style = HandsUpTypography.title3.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = missionGoal,
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
                    content1 = period.query,
                    title2 = stringResource(R.string.mission_content_max_title),
                    content2 = maxCondition,
                    title3 = stringResource(R.string.mission_content_median_title),
                    content3 = medianCondition,
                )
            }
        }
    }
}

@Preview(name = "JobMissionCard")
@Composable
private fun PreviewJobMissionCard() {
    JobMissionCard(
        department = "음성 1센터",
        jobGroup = 1,
        missionName = "생산성 향상",
        missionGoal = "5번 연속 두둥 경험치 획득",
        period = MissionPeriod.WEEK,
        maxCondition = "5.1 이상",
        medianCondition = "4.3 이상",
        {}
    )
}