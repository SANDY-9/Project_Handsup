package com.tenday.feature.mission

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.mission.GetJobMissionUseCase
import com.tenday.core.domain.usecases.mission.GetLeaderMissionUseCase
import com.tenday.core.domain.usecases.mission.GetPersonnelMissionUseCase
import com.tenday.core.domain.usecases.mission.GetProjectMissionUseCase
import com.tenday.feature.mission.model.MissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
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

    init {
        getLeaderMissionUseCase().onStart {
            Log.e("확인", "로딩 ", )
        }.onEach {
            Log.e("확인", "$it ", )
        }.catch {
            Log.e("확인", "$it ", )
        }.launchIn(viewModelScope)

        getJobMissionUseCase().onStart {
            Log.e("확인", "로딩 ")
        }.onEach {
            Log.e("확인", "$it ")
        }.catch {
            Log.e("확인", "$it ")
        }.launchIn(viewModelScope)

        getProjectMissionUseCase().onStart {
            Log.e("확인", "로딩 ")
        }.onEach {
            Log.e("확인", "$it ")
        }.catch {
            Log.e("확인", "$it ")
        }.launchIn(viewModelScope)

        getPersonnelMissionUseCase().onStart {
            Log.e("확인", "로딩 ")
        }.onEach {
            Log.e("확인", "$it ")
        }.catch {
            Log.e("확인", "$it ")
        }.launchIn(viewModelScope)

    }

}