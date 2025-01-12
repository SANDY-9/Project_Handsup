package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpTextureCard
import com.tenday.designsystem.components.HandsUpThreeSpaceTable
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.LinearGradientOrange
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionToolTipTitle

@Composable
internal fun ImproveWorkMissionCard(
    jobFamily: String,
    jobGroup: Int,
    onShowTooltip: () -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpTextureCard(
        modifier = modifier.width(300.dp),
        gradient = LinearGradientOrange,
    ) {
        MissionToolTipTitle(
            jobFamily = jobFamily,
            jobGroup = jobGroup,
            onShowTooltip = onShowTooltip,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        Text(
            text = stringResource(R.string.mission_leader_improve_title),
            style = HandsUpTypography.title2.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = stringResource(R.string.mission_leader_improve_desc),
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
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

@Preview(name = "ImproveWorkMissionCard")
@Composable
private fun PreviewImproveWorkMissionCard() {
    ImproveWorkMissionCard("음성 1센터", 1, {})
}