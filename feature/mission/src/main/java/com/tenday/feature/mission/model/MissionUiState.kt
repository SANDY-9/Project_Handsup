package com.tenday.feature.mission.model

internal sealed interface MissionUiState {
    data object Loading: MissionUiState
    data class Success(val data: HandsUpMission): MissionUiState
    data object Fail: MissionUiState
}