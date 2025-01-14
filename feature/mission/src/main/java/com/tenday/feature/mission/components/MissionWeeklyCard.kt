package com.tenday.feature.mission.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.model.MissionExp
import com.tenday.designsystem.components.missionCard.MissionCheckItem
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
internal fun MissionWeeklyCard(
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
            .padding(20.dp)
    ) {
        Text(
            text = "${month}월 미션",
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin12))
        Row {
            repeat(5) { num ->
                val item = expList.getOrNull(num)
                val title = item?.startDate?.let { "$it~${item.endDate}" }
                MissionCheckItem(
                    date = item?.index,
                    dateTitle = title,
                    achieveGrade = item?.achieveGrade ?: AchieveGrade.NULL
                )
                val isNullLastItem = expList.size < 5 && num >= expList.lastIndex
                if(num < 4) {
                    HorizontalDivider(
                        modifier = modifier
                            .weight(1f)
                            .padding(top = Dimens.margin16),
                        thickness = 4.dp,
                        color = if(isNullLastItem) Color.Transparent else Gray100,
                    )
                }
            }
        }
    }
}


@Preview(name = "WeeklyLeaderMissionCard")
@Composable
private fun PreviewWeeklyLeaderMissionCard() {
    MissionWeeklyCard(
        2,
        listOf(
            MissionExp(
                achieveGrade = AchieveGrade.MAX,
                exp = 30,
                index = 3,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
            MissionExp(
                achieveGrade = AchieveGrade.MEDIAN,
                exp = 30,
                index = 4,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
            MissionExp(
                achieveGrade = AchieveGrade.NULL,
                exp = 30,
                index = 5,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
        )
    )
}