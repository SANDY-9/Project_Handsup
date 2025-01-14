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
import com.tenday.core.model.LeaderMission
import com.tenday.designsystem.theme.Gray100

@Composable
internal fun MissionLeaderView(
    data: LeaderMission,
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
            type = type,
            onFullScroll = { fullScroll ->
                visibleTable = fullScroll
                onListScroll()
            },
            modifier = modifier.fillMaxSize(),
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
            type = "업무개선",
            jobFamily = "음성 1센터",
            jobGroup = 1,
            onPageChange = {},
            onPagerSwipe = {},
            onListScroll = {},
            onShowImproveToolTip = {},
            onShowSpecialTooltip = {},
        )
    }
}