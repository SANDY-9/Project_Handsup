package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.MissionDetails
import com.tenday.designsystem.theme.Gray100

@Composable
internal fun MissionLeaderView(
    data: LeaderMission,
    totalExp: Int,
    onPagerSwipe: () -> Unit,
    onListScroll: () -> Unit,
    onShowToolTip: (IntOffset) -> Unit,
    modifier: Modifier = Modifier
) {
    var visibleTable by remember { mutableStateOf(true) }
    var currentPage by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        MissionLeaderCardPager(
            modifier = modifier.fillMaxWidth(),
            department = data.department,
            jobGroup = data.jobGroup,
            item = data.missionList,
            visibleTable = visibleTable,
            onPageChange = { page ->
                currentPage = page
            },
            onPagerSwipe = onPagerSwipe,
            onShowToolTip = onShowToolTip,
        )
        MissionLeaderExpList(
            modifier = modifier.fillMaxSize(),
            expList = data.missionList[currentPage].expList,
            totalExp = totalExp,
            period = data.missionList[currentPage].period,
            onFullScroll = { fullScroll ->
                visibleTable = fullScroll
                onListScroll()
            },
        )
    }
}


@Preview(name = "MissionLeaderView", widthDp = 500)
@Composable
private fun PreviewMissionLeaderView() {
    Box(
        modifier = Modifier.background(
            color = Gray100,
        )
    ) {
        MissionLeaderView(
            data = LeaderMission(
                department = "음성1센터",
                jobGroup = 1,
                missionCount = 3,
                missionList = listOf(
                    MissionDetails(
                        expList = emptyList(),
                        maxCondition = "개선 리드",
                        maxExp = 80,
                        medianCondition = "개선 참여",
                        medianExp = 20,
                        period = MissionPeriod.WEEK,
                        missionGoal = "열심히 업무개선하자",
                        missionName = "업무개선"
                    ),
                    MissionDetails(
                        expList = emptyList(),
                        maxCondition = "개선 리드",
                        maxExp = 80,
                        medianCondition = "개선 참여",
                        medianExp = 20,
                        period = MissionPeriod.WEEK,
                        missionGoal = "열심히 업무개선하자",
                        missionName = "업무개선"
                    )
                ),
                totalExp = 3000,
            ),
            totalExp = 4000,
            onPagerSwipe = {},
            onListScroll = {},
            onShowToolTip = {},
        )
    }
}