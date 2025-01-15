package com.tenday.feature.home

import androidx.lifecycle.ViewModel
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.usecases.exp.GetLastExpListUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.core.model.Exp
import com.tenday.feature.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
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
        getUserDetailsUseCase()
        getLastExpListUseCase(listSize = 3)
        combine(
            getUserDetailsUseCase(),
            getLastExpListUseCase(listSize = 3)
        ) { userDetails, expMap ->
            HomeUiState.Success(
                expList = expMap.toExpList(),
                userDetails = userDetails
            )
        }.onStart {
            _homeUiState.value = HomeUiState.Loading
        }.onEach {
            _homeUiState.value = it
        }.catch {
            _homeUiState.value = HomeUiState.Fail
        }
    }

    private fun Map<Int, List<Exp>>.toExpList(): List<Exp> {
        return values
            .flatten()
            .sortedByDescending {
                it.expAt
            }
    }

    suspend fun updateNotificationState(enable: Boolean) {
        appPrefsRepository.updateNotificationState(enable)
    }

}