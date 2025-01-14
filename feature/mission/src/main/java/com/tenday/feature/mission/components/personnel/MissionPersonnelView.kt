package com.tenday.feature.mission.components.personnel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.model.PersonnelMission
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.mission.MissionMenu
import com.tenday.feature.mission.components.MissionExpTitle

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionPersonnelView(
    data: List<PersonnelMission>,
    totalExp: Int,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin20,
            top = 0.dp
        ),
    ) {
        stickyHeader {
            MissionExpTitle(
                title = MissionMenu.인사평가.name,
                exp = totalExp,
            )
        }
        items(data) {
            Column {
                when(it.term) {
                    PersonnelMission.EvaluationTerm.상반기 -> PersonnelCardFirstHalf(
                        date = it.expAt,
                        exp = it.exp,
                        achieveGrade = it.achieveGrade,
                        diff = it.diff,
                    )
                    PersonnelMission.EvaluationTerm.하반기 -> PersonnelCardSecondHalf(
                        date = it.expAt,
                        exp = it.exp,
                        achieveGrade = it.achieveGrade,
                        diff = it.diff,
                    )
                }
                Spacer(modifier = modifier.height(Dimens.margin12))
            }
        }
    }
}

@Preview(name = "MissionPersonnelView")
@Composable
private fun PreviewMissionPersonnelView() {
    MissionPersonnelView(
        data = listOf(
            PersonnelMission(
                achieveGrade = AchieveGrade.A등급,
                diff = 1,
                exp = 400,
                expAt = "2025.01.02",
                term = PersonnelMission.EvaluationTerm.상반기,
            ),
            PersonnelMission(
                achieveGrade = AchieveGrade.NULL,
                diff = null,
                exp = null,
                expAt = null,
                term = PersonnelMission.EvaluationTerm.하반기,
            )
        ),
        totalExp = TODO()
    )
}