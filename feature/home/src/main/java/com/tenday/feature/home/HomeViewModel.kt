package com.tenday.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.domain.usecases.exp.GetLastExpListUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.feature.home.model.ExpListState
import com.tenday.feature.home.model.UserDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val getLastExpListUseCase: GetLastExpListUseCase,
): ViewModel() {

    private val _userState = MutableStateFlow<UserDetailsState>(UserDetailsState.Loading)
    val userState: StateFlow<UserDetailsState> get() = _userState

    private val _expState = MutableStateFlow<ExpListState>(ExpListState.EmptyExp)
    val expState: StateFlow<ExpListState> get() = _expState

    var jobFamily: JobFamily = JobFamily.F
        private set

    init {
        fetchUserDetails()
        fetchExpList()
    }

    private fun fetchUserDetails() {
        getUserDetailsUseCase()
            .onEach { data ->
                _userState.value = UserDetailsState.Success(data)
                jobFamily = data.jobFamily
            }
            .catch {
                _userState.value = UserDetailsState.Fail
            }
            .launchIn(viewModelScope)
    }

    private fun fetchExpList() {
        getLastExpListUseCase(
            listSize = 3
        )
            .onEach { data ->
                if (data.isEmpty()) {
                    _expState.value = ExpListState.EmptyExp
                } else {
                    _expState.value = ExpListState.Success(data)
                }
            }
            .catch {
                _expState.value = ExpListState.Fail
            }
            .launchIn(viewModelScope)
    }

}