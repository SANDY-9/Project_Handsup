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
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.components.HandsUpTextureCard
import com.tenday.designsystem.components.HandsUpThreeSpaceTable
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.SingleGradientBlue
import com.tenday.designsystem.theme.TransparentWhite12
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R

@Composable
private fun PersonnelCardFirstHalf(
    date: String?,
    exp: Int?,
    achieveGrade: AchieveGrade,
    diff: Int?,
    modifier: Modifier = Modifier
) {
    val dateText = if (date == null) "-" else
        "$date " + stringResource(R.string.mission_personnel_date_desc)
    HandsUpTextureCard(
        modifier = modifier,
        gradient = SingleGradientBlue,
        horizontalAlignment = Alignment.CenterHorizontally,
        bottom = Dimens.margin28,
    ) {
        Text(
            text = stringResource(R.string.mission_personnel_first_date),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = stringResource(R.string.mission_personnel_first_title),
            style = HandsUpTypography.title3.copy(
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            modifier = modifier
                .background(
                    color = TransparentWhite12,
                    shape = RoundedCornerShape(Dimens.cornerShape4),
                )
                .padding(
                    vertical = Dimens.margin4,
                    horizontal = Dimens.margin6,
                ),
            text = dateText,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        HandsUpThreeSpaceTable(
            title1 = stringResource(R.string.mission_personnel_grade_title),
            content1 = achieveGrade.alias,
            title2 = stringResource(R.string.mission_personnel_do_title),
            content2 = exp?.toData() ?: "-",
            title3 = stringResource(R.string.mission_personnel_analysis_title),
            content3 = if(diff == null) "-" else "${diff}등급",
            up = diff != null,
        )
    }
}
@Preview(name = "PersonnelMissionCardFirstHalf")
@Composable
private fun PreviewPersonnelMissionCardFirstHalf() {
    PersonnelCardFirstHalf(
        "2025.01.11",
        300,
        AchieveGrade.C등급,
        2
    )
}