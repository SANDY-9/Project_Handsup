package com.tenday.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.usecases.exp.GetLastExpListUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.feature.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    getUserDetailsUseCase: GetUserDetailsUseCase,
    getLastExpListUseCase: GetLastExpListUseCase,
    private val appPrefsRepository: AuthPrefsRepository,
): ViewModel() {

    private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val homeUiState = _homeUiState.asStateFlow()

    init {
        combine(
            getUserDetailsUseCase(),
            getLastExpListUseCase(listSize = 3)
        ) { userDetails, expDetails ->
            HomeUiState.Success(
                expDetails = expDetails,
                userDetails = userDetails
            )
        }.onStart {
            _homeUiState.value = HomeUiState.Loading
        }.onEach {
            _homeUiState.value = it
        }.catch {
            _homeUiState.value = HomeUiState.Fail
        }.launchIn(viewModelScope)
    }

    suspend fun updateNotificationState(enable: Boolean) {
        appPrefsRepository.updateNotificationState(enable)
    }

}