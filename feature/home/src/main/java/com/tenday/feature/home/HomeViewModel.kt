package com.tenday.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.core.model.UserDetails
import com.tenday.feature.home.model.ExpListState
import com.tenday.feature.home.model.UserDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    getUserDetailsUseCase: GetUserDetailsUseCase,
): ViewModel() {

    private val _userState = MutableStateFlow<UserDetailsState>(UserDetailsState.Loading)
    val userState: StateFlow<UserDetailsState> get() = _userState

    private val _expState = MutableStateFlow<ExpListState>(ExpListState.Loading)
    val expState: StateFlow<ExpListState> get() = _expState

    private val testFlow = flow { emit(1) }
    init {
        merge(getUserDetailsUseCase(), testFlow).onEach { data ->
            when(data) {
                is UserDetails -> _userState.value = UserDetailsState.Success(data)
            }
        }.catch {
            _userState.value = UserDetailsState.Fail
            _expState.value = ExpListState.Fail
        }.launchIn(viewModelScope)
    }

}