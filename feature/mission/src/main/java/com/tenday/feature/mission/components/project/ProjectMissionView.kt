package com.tenday.feature.mission.components.project

import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.ProjectMission
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.mission.MissionMenu
import com.tenday.feature.mission.components.MissionExpTitle

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionProjectView(
    data: List<ProjectMission>,
    totalExp: Int,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin24,
            top = 0.dp
        ),
    ) {
        stickyHeader {
            MissionExpTitle(
                title = MissionMenu.전사프로젝트.name,
                exp = totalExp,
            )
        }
        items(data) { mission ->
            ProjectMissionCard(data = mission)
            Spacer(modifier = modifier.height(Dimens.margin12))
        }
    }
}

@Preview(name = "MissionProjectView")
@Composable
private fun PreviewMissionProjectView() {
    MissionProjectView(
        data = listOf(
            ProjectMission(
                content = "환불 절차를 간소화하고 고객의 불편을 최소화 할 수있는 " +
                        "정책 개선 및 운영 비용 절감 프로젝트",
                exp = 2440,
                expAt = "2025.01.11",
                period = MissionPeriod.WEEK,
                missionName = "환불 프로세스 최적화"
            ),
            ProjectMission(
                content = "환불 절차를 간소화하고 고객의 불편을 최소화 할 수있는 " +
                        "정책 개선 및 운영 비용 절감 프로젝트",
                exp = 2440,
                expAt = "2025.01.11",
                period = MissionPeriod.WEEK,
                missionName = "환불 프로세스 최적화"
            ),
            ProjectMission(
                content = "환불 절차를 간소화하고 고객의 불편을 최소화 할 수있는 " +
                        "정책 개선 및 운영 비용 절감 프로젝트",
                exp = 2440,
                expAt = "2025.01.11",
                period = MissionPeriod.WEEK,
                missionName = "환불 프로세스 최적화"
            ),
        ),
        totalExp = 5000,
    )
}