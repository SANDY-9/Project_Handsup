
package com.tenday.feature.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.theme.Gray100
import com.tenday.feature.mission.components.MissionTitleBar
import com.tenday.feature.mission.components.MissionToolTip
import com.tenday.feature.mission.components.job.MissionJobView
import com.tenday.feature.mission.components.leader.MissionLeaderView
import com.tenday.feature.mission.components.personnel.MissionPersonnelView
import com.tenday.feature.mission.components.project.MissionProjectView
import com.tenday.feature.mission.model.HandsUpMission
import com.tenday.feature.mission.model.MissionUiState

@Composable
internal fun MissionRoute(
    viewModel: MissionViewModel = hiltViewModel()
) {
    val currentTab by viewModel.currentTab.collectAsStateWithLifecycle()
    val uiState by viewModel.missionUiState.collectAsStateWithLifecycle()

    MissionScreen(
        currentTab = currentTab,
        uiState = uiState,
        onTabSelect = viewModel::updateCurrentTabState
    )
}

@Composable
internal fun MissionScreen(
    currentTab: MissionMenu,
    uiState: MissionUiState,
    onTabSelect: (MissionMenu) -> Unit,
    modifier: Modifier = Modifier,
) {
    var visibleToolTip by remember { mutableStateOf(false) }
    var tooltipPosition by remember { mutableStateOf(IntOffset.Zero) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Gray100)
            .pointerInput(Unit) {
                detectTapGestures {
                    visibleToolTip = false
                }
            }
    ) {
        Column {
            MissionTitleBar(
                currentSelectedTab = currentTab,
                onTabSelect = onTabSelect,
            )
            when (uiState) {
                is MissionUiState.Success -> {
                    when (uiState.data) {
                        is HandsUpMission.Leader -> MissionLeaderView(
                            data = uiState.data.mission,
                            totalExp = uiState.data.mission.totalExp,
                            onPagerSwipe = { visibleToolTip = false },
                            onListScroll = { visibleToolTip = false },
                            onShowToolTip = {
                                tooltipPosition = it
                                visibleToolTip = true
                            }
                        )

                        is HandsUpMission.Job -> MissionJobView(
                            data = uiState.data.mission,
                            totalExp = uiState.data.mission.totalExp,
                            onListScroll = { visibleToolTip = false },
                            onShowJobToolTip = {
                                tooltipPosition = it
                                visibleToolTip = true
                            },
                        )

                        is HandsUpMission.Project -> {
                            val totalExp by remember { mutableIntStateOf(
                                uiState.data.mission.sumOf { it.exp }
                            ) }
                            MissionProjectView(
                                data = uiState.data.mission,
                                totalExp = totalExp,
                            )
                        }
                        is HandsUpMission.Personnel -> {
                            val totalExp by remember {
                                mutableIntStateOf(
                                    uiState.data.mission.sumOf { it.exp ?: 0 }
                                )
                            }
                            MissionPersonnelView(
                                data = uiState.data.mission,
                                totalExp = totalExp,
                            )
                        }
                    }
                }

                MissionUiState.Loading -> {

                }

                MissionUiState.Fail -> {

                }
            }
            if (visibleToolTip) {
                MissionToolTip(
                    missionName = "생산성 향상",
                    position = tooltipPosition,
                )
            }
        }
    }
}

@Preview(name = "MissionScreen")
@Composable
private fun PreviewMissionScreen() {
    var currentClickTab by remember { mutableStateOf(MissionMenu.리더부여) }
    MissionScreen(
        currentClickTab,
        MissionUiState.Loading,
        { currentClickTab = it }
    )
}