package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionLeaderView(
    jobFamily: String,
    jobGroup: Int,
    modifier: Modifier = Modifier
) {
    var type by remember { mutableStateOf("업무개선") }
    var visibleTable by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        MissionLeaderCardPager(
            modifier = modifier.fillMaxWidth(),
            jobFamily = jobFamily,
            jobGroup = jobGroup,
            visibleTable = visibleTable,
            onPageChange = { page ->
                type = if(page == 0) "업무개선" else "월특근"
            },
        )
        MissionLeaderExpList(
            type = type,
            onFullScroll = { fullScroll ->
                visibleTable = fullScroll
            },
            modifier = modifier.fillMaxSize(),
        )
    }
}


@Preview(name = "MissionLeaderView", widthDp = 500)
@Composable
private fun PreviewMissionLeaderView() {
    Box {
        MissionLeaderView("음성 1센터", 1,)
    }
}