package com.tenday.feature.mission

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.mission.GetJobMissionUseCase
import com.tenday.core.domain.usecases.mission.GetLeaderMissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getLeaderMissionUseCase: GetLeaderMissionUseCase,
    private val getJobMissionUseCase: GetJobMissionUseCase,
): ViewModel() {

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

    }

}