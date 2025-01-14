package com.tenday.feature.mission.components.personnel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpTextureCard
import com.tenday.designsystem.components.HandsUpThreeSpaceTable
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.SingleGradientGray
import com.tenday.designsystem.theme.TransparentWhite12
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R

// 하반기
@Composable
private fun PersonnelCardSecondHalf(
    modifier: Modifier = Modifier
) {
    HandsUpTextureCard(
        modifier = modifier,
        gradient = SingleGradientGray,
        horizontalAlignment = Alignment.CenterHorizontally,
        bottom = Dimens.margin28,
    ) {
        Text(
            text = "01.01 - 06.30",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = stringResource(R.string.mission_personnel_second_title),
            style = HandsUpTypography.title3.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            modifier = modifier.background(
                color = TransparentWhite12,
                shape = RoundedCornerShape(Dimens.cornerShape4),
            ).padding(
                vertical = Dimens.margin4,
                horizontal = Dimens.margin6,
            ),
            text = "-",
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        HandsUpThreeSpaceTable(
            title1 = stringResource(R.string.mission_personnel_grade_title),
            content1 = stringResource(R.string.mission_personnel_grade_yet),
            title2 = stringResource(R.string.mission_personnel_do_title),
            content2 = "-",
            title3 = stringResource(R.string.mission_personnel_analysis_title),
            content3 = "-",
        )
    }
}

@Preview(name = "PersonnelMissionCard")
@Composable
private fun PreviewPersonnelMissionCard() {
    PersonnelCardSecondHalf()
}