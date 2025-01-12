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
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
fun MonthlyMissionCard(
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
        verticalArrangement = Arrangement.spacedBy(Dimens.margin12),
    ) {
        Text(
            text = "2025년 미션",
            style = HandsUpTypography.title5,
        )
        WeeklyMissionCheckItem(
            listOf(1,2,3,4,5),
            listOf("1월", "2월", "3월", "4월", "5월")
        )
        WeeklyMissionCheckItem(
            listOf(6,7,8,9,10),
            listOf("6월", "7월", "8월", "9월", "10월")
        )
        WeeklyMissionCheckItem(
            listOf(11, 12),
            listOf("11월", "12월")
        )
    }

}

@Composable
fun WeeklyMissionCard(
    list: List<Int> = listOf(1,2,3,4,5),
    dateTitleList: List<String> = listOf(
        "01.02~01.05", "01.02~01.05", "01.02~01.05", "99.99~02.08", "99.99~02.08",
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
            text = "1월 미션",
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        WeeklyMissionCheckItem(list, dateTitleList)
    }
}

@Preview
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MonthlyMissionCard()
        WeeklyMissionCard()
    }
}