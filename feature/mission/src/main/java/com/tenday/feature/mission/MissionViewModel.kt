package com.tenday.feature.mission

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.mission.GetJobMissionUseCase
import com.tenday.core.domain.usecases.mission.GetLeaderMissionUseCase
import com.tenday.core.domain.usecases.mission.GetPersonnelMissionUseCase
import com.tenday.core.domain.usecases.mission.GetProjectMissionUseCase
import com.tenday.feature.mission.model.HandsUpMission
import com.tenday.feature.mission.model.MissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MissionViewModel @Inject constructor(
    private val getLeaderMissionUseCase: GetLeaderMissionUseCase,
    private val getJobMissionUseCase: GetJobMissionUseCase,
    private val getProjectMissionUseCase: GetProjectMissionUseCase,
    private val getPersonnelMissionUseCase: GetPersonnelMissionUseCase,
): ViewModel() {

    private val _currentTab: MutableStateFlow<MissionMenu> = MutableStateFlow(MissionMenu.리더부여)
    val currentTab = _currentTab.asStateFlow()

    private val _missionUiState: MutableStateFlow<MissionUiState> = MutableStateFlow(MissionUiState.Loading)
    val missionUiState = _missionUiState.asStateFlow()

    private val missionItem = mutableMapOf<MissionMenu, HandsUpMission>()
    private fun setMissionItem(missionMenu: MissionMenu, handsUpMission: HandsUpMission) {
        missionItem[missionMenu] = handsUpMission
    }

    init {
        viewModelScope.launch {
            currentTab.collectLatest {
                when(it) {
                    MissionMenu.리더부여 -> fetchLeaderMission()
                    MissionMenu.직무미션 -> fetchJobMission()
                    MissionMenu.전사프로젝트 -> fetchProjectMission()
                    MissionMenu.인사평가 -> fetchPersonnelMission()
                }
            }
        }
    }

    fun updateCurrentTabState(tab: MissionMenu) {
        _currentTab.value = tab
    }

    private fun updateMissionUiState(mission: HandsUpMission) {
        _missionUiState.value = MissionUiState.Success(data = mission)
    }

    private fun changeMissionState(missionMenu: MissionMenu): Boolean {
        val mission = missionItem[missionMenu] ?: return false
        updateMissionUiState(mission)
        return true
    }

    private fun fetchLeaderMission() {
        val changed = changeMissionState(MissionMenu.리더부여)
        if(!changed) {
            getLeaderMissionUseCase().onStart {
                _missionUiState.value = MissionUiState.Loading
            }.onEach { data ->
                val leaderMission = HandsUpMission.Leader(data)
                updateMissionUiState(leaderMission)
                setMissionItem(MissionMenu.리더부여, leaderMission)
            }.catch {
                _missionUiState.value = MissionUiState.Fail
            }.launchIn(viewModelScope)
        }
    }

    private fun fetchJobMission() {
        val changed = changeMissionState(MissionMenu.직무미션)
        if(!changed) {
            getJobMissionUseCase().onStart {
                _missionUiState.value = MissionUiState.Loading
            }.onEach { data ->
                val jobMission = HandsUpMission.Job(data)
                updateMissionUiState(jobMission)
                setMissionItem(MissionMenu.직무미션, jobMission)
            }.catch {
                _missionUiState.value = MissionUiState.Fail
            }.launchIn(viewModelScope)
        }
    }

    private fun fetchProjectMission() {
        val changed = changeMissionState(MissionMenu.전사프로젝트)
        if(!changed) {
            getProjectMissionUseCase().onStart {
                _missionUiState.value = MissionUiState.Loading
            }.onEach { data ->
                val projectMission = HandsUpMission.Project(data)
                updateMissionUiState(projectMission)
                setMissionItem(MissionMenu.전사프로젝트, projectMission)
            }.catch {
                _missionUiState.value = MissionUiState.Fail
            }.launchIn(viewModelScope)
        }
    }

    private fun fetchPersonnelMission() {
        val changed = changeMissionState(MissionMenu.인사평가)
        if(!changed) {
            getPersonnelMissionUseCase().onStart {
                _missionUiState.value = MissionUiState.Loading
            }.onEach { data ->
                val personnelMission = HandsUpMission.Personnel(data)
                updateMissionUiState(personnelMission)
                setMissionItem(MissionMenu.인사평가, personnelMission)
            }.catch {
                _missionUiState.value = MissionUiState.Fail
            }.launchIn(viewModelScope)
        }
    }

}