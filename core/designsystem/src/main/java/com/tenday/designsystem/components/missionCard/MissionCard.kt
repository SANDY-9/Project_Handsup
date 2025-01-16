package com.tenday.designsystem.components.missionCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
fun MonthlyMissionCard(
    year: Int,
    achieve: List<AchieveGrade?>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .blurShadow(
                offsetY = 2.dp,
                blurRadius = 4.dp,
                borderRadius = Dimens.margin12,
                color = CardShadowLight,
            )
            .background(
                color = White,
                shape = RoundedCornerShape(Dimens.cornerShape12),
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(Dimens.margin20),
    ) {
        Text(
            text = "${year}년 미션",
            style = HandsUpTypography.title5,
        )
        MonthMissionCheckItem(
            listOf(1,2,3,4,5),
            listOf(
                achieve.getOrNull(0),
                achieve.getOrNull(1),
                achieve.getOrNull(2),
                achieve.getOrNull(3),
                achieve.getOrNull(4),
            ),
        )
        MonthMissionCheckItem(
            listOf(6,7,8,9,10),
            listOf(
                achieve.getOrNull(5),
                achieve.getOrNull(6),
                achieve.getOrNull(7),
                achieve.getOrNull(8),
                achieve.getOrNull(9),
            )
        )
        MonthMissionCheckItem(
            listOf(11, 12),
            listOf(
                achieve.getOrNull(10),
                achieve.getOrNull(11),
            ),
        )
    }
}

@Composable
fun WeeklyMissionCard(
    index: Int,
    list: List<Int> = listOf(1,2,3,4,5),
    dateTitleList: List<String> = listOf(
        "01.02~01.05", "01.02~01.05", "01.02~01.05", "99.99~02.08", "99.99~02.08",
    ),
    achieveGradeList: List<AchieveGrade> = listOf(
        AchieveGrade.MAX, AchieveGrade.MEDIAN, AchieveGrade.MAX, AchieveGrade.MEDIAN, AchieveGrade.MEDIAN,
    ),
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .blurShadow(
                offsetY = 2.dp,
                blurRadius = 4.dp,
                borderRadius = Dimens.margin12,
                color = CardShadowLight,
            )
            .background(
                color = White,
                shape = RoundedCornerShape(Dimens.cornerShape12),
            )
            .padding(20.dp)
    ) {
        Text(
            text = "${index}월 미션",
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        WeeklyMissionCheckItem(list, dateTitleList, achieveGradeList)
    }
}

@Preview
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MonthlyMissionCard(2025, listOf(
            AchieveGrade.MAX,
            AchieveGrade.MEDIAN,
            AchieveGrade.MAX,
        ))
        WeeklyMissionCard(1)
    }
}