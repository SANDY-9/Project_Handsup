package com.tenday.designsystem.components.missionCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MonthlyMissionItem(
    month: List<Int>,
    grade: List<AchieveGrade?>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        repeat(4) { index ->
            val index = month.getOrNull(index + 1)
            HorizontalDivider(
                modifier = modifier.weight(1f).padding(top = Dimens.margin16),
                color = index?.let { Gray100 } ?: Color.Transparent,
                thickness = 4.dp,
            )
        }
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        repeat(5) { index ->
            val gradeItem = grade.getOrNull(index)
            val monthItem = month.getOrNull(index)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MissionGradeItem(
                    index = monthItem,
                    achieveGrade = gradeItem ?: AchieveGrade.NULL
                )
                Spacer(modifier = modifier.height(Dimens.margin6))
                Text(
                    text = monthItem?.let { "${it}월" } ?: "",
                    style = HandsUpTypography.body3,
                    color = Gray500,
                )
            }
        }
    }
}

@Composable
private fun MissionGradeItem(
    index: Int?,
    achieveGrade: AchieveGrade,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(36.dp).alpha(
            alpha = if(index == null) 0.0f else 1.0f
        ),
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
                text = "$index",
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
}


@Preview(name = "MonthlyMissionItem")
@Composable
private fun PreviewMonthlyMissionItem() {
    MonthlyMissionItem(
        listOf(1, 2, 3, 4, 6,),
        listOf(AchieveGrade.MAX, AchieveGrade.MEDIAN, AchieveGrade.MAX)
    )
}