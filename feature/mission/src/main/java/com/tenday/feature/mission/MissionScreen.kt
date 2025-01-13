
package com.tenday.feature.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.tenday.designsystem.theme.Gray100
import com.tenday.feature.mission.components.MissionTitleBar
import com.tenday.feature.mission.components.MissionToolTip
import com.tenday.feature.mission.components.job.MissionJobView
import com.tenday.feature.mission.components.leader.MissionLeaderView
import com.tenday.feature.mission.components.personnel.MissionPersonnelView
import com.tenday.feature.mission.components.project.MissionProjectView

@Composable
internal fun MissionRoute() {
    var currentClickTab by remember { mutableStateOf(MissionMenu.리더부여) }
    MissionScreen(currentClickTab, { currentClickTab = it })
}

@Composable
internal fun MissionScreen(
    currentTab: MissionMenu,
    onTabSelect: (MissionMenu) -> Unit,
    modifier: Modifier = Modifier,
) {
    var visibleToolTip by remember { mutableStateOf(false) }
    var tooltipPosition by remember { mutableStateOf(IntOffset.Zero) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Gray100)
    ) {
        Column {
            MissionTitleBar(
                currentSelectedTab = currentTab,
                onTabSelect = onTabSelect,
            )
            when (currentTab) {
                MissionMenu.리더부여 -> MissionLeaderView(
                    "음성 1센터", 1,
                    onShowImproveToolTip = {
                        tooltipPosition = it
                        visibleToolTip = true
                    },
                    onShowSpecialTooltip = {
                        tooltipPosition = it
                        visibleToolTip = true
                    },
                )
                MissionMenu.직무미션 -> MissionJobView("음성 1센터", 1)
                MissionMenu.전사프로젝트 -> MissionProjectView()
                MissionMenu.인사평가 -> MissionPersonnelView()
            }
        }
        if(visibleToolTip) {
            MissionToolTip(
                position = tooltipPosition,
            )
        }
    }
}

@Preview(name = "MissionScreen")
@Composable
private fun PreviewMissionScreen() {
    var currentClickTab by remember { mutableStateOf(MissionMenu.리더부여) }
    MissionScreen(currentClickTab, { currentClickTab = it })
}