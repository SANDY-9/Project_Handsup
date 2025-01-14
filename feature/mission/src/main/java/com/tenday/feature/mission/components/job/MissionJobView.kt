package com.tenday.feature.mission.components.job

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.JobMission
import com.tenday.core.model.MissionDetails
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionJobView(
    data: JobMission,
    totalExp: Int,
    onListScroll: () -> Unit,
    onShowJobToolTip: (IntOffset) -> Unit,
    modifier: Modifier = Modifier,
) {
    var visibleTable by rememberSaveable { mutableStateOf(true) }

    val lazyColumnState = rememberLazyListState()
    LaunchedEffect(lazyColumnState) {
        snapshotFlow { lazyColumnState.firstVisibleItemScrollOffset }.collectLatest { offset ->
            // 스크롤 오프셋에 따라 크기 변경
            visibleTable = offset <= 0
            onListScroll()
        }
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = White),
        ) {
            Box(
                modifier = modifier.padding(
                    start = Dimens.margin20,
                    end = Dimens.margin20,
                    bottom = Dimens.margin16,
                )
            ) {
                JobMissionCard(
                    department = data.department,
                    jobGroup = data.jobGroup,
                    missionName = data.missionDetails.missionName,
                    missionGoal = data.missionDetails.missionGoal,
                    period = data.missionDetails.period,
                    maxCondition = data.missionDetails.maxCondition,
                    medianCondition = data.missionDetails.medianCondition,
                    visibleTable = visibleTable,
                    onShowTooltip = onShowJobToolTip,
                )
            }
        }
        MissionJobExpList(
            totalExp = totalExp,
            lazyColumnState = lazyColumnState,
            period = data.missionDetails.period,
            expList = data.missionDetails.expList,
        )
    }
}

@Preview(name = "MissionJobView")
@Composable
private fun PreviewMissionJobView() {
    MissionJobView(
        JobMission(
            department = "음성1센터",
            jobGroup = 1,
            totalExp = 5000,
            missionDetails = MissionDetails(
                expList = emptyList(),
                maxCondition = "개선 리드",
                maxExp = 80,
                medianCondition = "개선 참여",
                medianExp = 20,
                period = MissionPeriod.WEEK,
                missionGoal = "열심히 생산성 향상하자",
                missionName = "생산성향상"
            ),
    ), 1, {}, {})
}