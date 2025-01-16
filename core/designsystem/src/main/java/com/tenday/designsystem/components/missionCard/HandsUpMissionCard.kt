package com.tenday.designsystem.components.missionCard

import WeeklyMissionItem
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.model.MissionExp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpMonthMissionCard(
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
        MonthlyMissionItem(
            listOf(1,2,3,4,5),
            listOf(
                achieve.getOrNull(0),
                achieve.getOrNull(1),
                achieve.getOrNull(2),
                achieve.getOrNull(3),
                achieve.getOrNull(4),
            ),
        )
        MonthlyMissionItem(
            listOf(6,7,8,9,10),
            listOf(
                achieve.getOrNull(5),
                achieve.getOrNull(6),
                achieve.getOrNull(7),
                achieve.getOrNull(8),
                achieve.getOrNull(9),
            )
        )
        MonthlyMissionItem(
            listOf(11, 12),
            listOf(
                achieve.getOrNull(10),
                achieve.getOrNull(11),
            ),
        )
    }
}

@Composable
fun HandsUpWeeklyMissionCard(
    month: Int,
    expList: List<MissionExp>,
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
            .padding(
                top = 20.dp,
                bottom = 20.dp,
                start = 20.dp,
                end = 11.dp,
            )
    ) {
        Text(
            text = "${month}월 미션",
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        WeeklyMissionItem(expList = expList)
    }
}

@Preview
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.background(
            color = Color.Magenta,
        ).padding(10.dp)
    ) {
        HandsUpMonthMissionCard(
            year = 2025,
            achieve = listOf(
                AchieveGrade.MAX,
                AchieveGrade.MEDIAN,
                AchieveGrade.MAX,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        HandsUpWeeklyMissionCard(
            month = 3,
            listOf(
                MissionExp(
                    achieveGrade = AchieveGrade.MAX,
                    exp = 30,
                    index = 1,
                    startDate = "02.04",
                    endDate = "06.09",
                    month = 1
                ),
                MissionExp(
                    achieveGrade = AchieveGrade.MEDIAN,
                    exp = 30,
                    index = 1,
                    startDate = "02.04",
                    endDate = "06.09",
                    month = 1
                ),
                MissionExp(
                    achieveGrade = AchieveGrade.MAX,
                    exp = 30,
                    index = 1,
                    startDate = "02.04",
                    endDate = "06.09",
                    month = 1
                ),
                MissionExp(
                    achieveGrade = AchieveGrade.NULL,
                    exp = 30,
                    index = 1,
                    startDate = "02.04",
                    endDate = "06.09",
                    month = 1
                ),
                MissionExp(
                    achieveGrade = AchieveGrade.NULL,
                    exp = 30,
                    index = 1,
                    startDate = "02.04",
                    endDate = "06.09",
                    month = 1
                ),
            )
        )
    }
}