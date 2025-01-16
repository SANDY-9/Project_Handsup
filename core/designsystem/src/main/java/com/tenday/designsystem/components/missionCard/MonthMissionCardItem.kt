package com.tenday.designsystem.components.missionCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.CheckMax
import com.tenday.designsystem.icons.CheckMedium
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray300
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
internal fun MonthMissionCheckItem(
    list: List<Int>,
    achieveGradeList: List<AchieveGrade?>,
    modifier: Modifier = Modifier,
) {
    Row {
        repeat(5) { num ->
            MonthMissionCheckItem(
                date = list.getOrNull(num),
                achieveGrade = achieveGradeList.getOrNull(num) ?: AchieveGrade.NULL
            )
            val isNullLastItem = list.size < 5 && num >= list.size - 1
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

@Composable
private fun MonthMissionCheckItem(
    date: Int?,
    achieveGrade: AchieveGrade,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        date?.let {
            Box(
                modifier = modifier.width(40.dp),
                contentAlignment = Alignment.Center
            ) {
                HorizontalDivider(
                    modifier = modifier
                        .matchParentSize()
                        .padding(top = Dimens.margin16),
                    thickness = 4.dp,
                    color = Gray100,
                )
                Box(
                    modifier = modifier
                        .size(36.dp)
                        .background(
                            color = Gray300,
                            shape = CircleShape,
                        )
                ) {
                    Text(
                        modifier = modifier.align(Alignment.Center),
                        text = "$date",
                        style = HandsUpTypography.body2.copy(
                            fontWeight = FontWeight.ExtraBold,
                            color = White,
                        ),
                    )
                }
                if(achieveGrade == AchieveGrade.MEDIAN) {
                    Image(
                        modifier = modifier.size(36.dp),
                        imageVector = Icons.CheckMedium,
                        contentDescription = null,
                    )
                }
                if(achieveGrade == AchieveGrade.MAX) {
                    Image(
                        modifier = modifier.size(36.dp),
                        imageVector = Icons.CheckMax,
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = modifier.height(Dimens.margin6))
            Text(
                text = date?.let { "${it}월" } ?: "",
                style = HandsUpTypography.body4.copy(
                    color = Gray500,
                ),
            )
        }
    }
}

@Preview(name = "MissionCardItem")
@Composable
private fun PreviewMissionCardItem() {
    MonthMissionCheckItem(
        listOf(1, 2, 3, 4),
        listOf(
            AchieveGrade.MAX, AchieveGrade.MEDIAN, AchieveGrade.MAX,
        ),
    )
}