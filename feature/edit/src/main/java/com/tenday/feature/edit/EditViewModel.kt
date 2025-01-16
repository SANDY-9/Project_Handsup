package com.tenday.feature.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.usecases.auth.RequestLogoutUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileBadgeUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileImageUseCase
import com.tenday.core.domain.usecases.user.UpdateUserPwdUseCase
import com.tenday.core.model.UserDetails
import com.tenday.feature.edit.model.EditInputState
import com.tenday.feature.edit.model.EditUiState
import com.tenday.feature.edit.model.UpdateType
import com.tenday.feature.edit.navigation.USER_DETAILS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EditViewModel @Inject constructor(
    private val updateUserPwdUseCase: UpdateUserPwdUseCase,
    private val updateProfileBadgeUseCase: UpdateProfileBadgeUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase,
    private val appPrefsRepository: AuthPrefsRepository,
    private val requestLogoutUseCase: RequestLogoutUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _editUiState: MutableStateFlow<EditUiState> = MutableStateFlow(EditUiState.None)
    val editUiState = _editUiState.asStateFlow()

    val notificationEnable = appPrefsRepository.getNotificationState()
        .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null,
    )

    fun updateNotiChange(enable: Boolean) {
        viewModelScope.launch {
            appPrefsRepository.updateNotificationState(enable)
        }
    }

    val user: StateFlow<UserDetails?> = savedStateHandle.getStateFlow(USER_DETAILS, null)

    fun setUserDetails(userDetails: UserDetails?) {
        userDetails?.let {
            savedStateHandle[USER_DETAILS] = it
        }
    }

    fun requestUpdateBadgeChange(badge: BadgeCode) {
        flow {
            emit(updateProfileBadgeUseCase(badge))
        }.onStart {
            _editUiState.value = EditUiState.Loading
        }.onEach {
            _editUiState.value = EditUiState.Success(UpdateType.PROFILE_BADGE)
            setUserDetails(
                user.value?.copy(profileBadgeCode = badge)
            )
        }.catch {
            _editUiState.value = EditUiState.Fail
        }.launchIn(viewModelScope)
    }

    private val _inputState = MutableStateFlow(
        EditInputState(
            pwdInput = "",
            pwdConfirmInput = "",
            pwdError = false,
            pwdConfirmError = false,
        )
    )
    val inputState: StateFlow<EditInputState> = _inputState.asStateFlow()

    fun updatePwdInputState(input: String) {
        val query = input.trim()
        _inputState.update {
            it.copy(
                pwdInput = query,
                pwdError = query.length < 4,
            )
        }
    }

    fun updatePwdConfirmInputState(input: String) {
        val query = input.trim()
        _inputState.update {
            it.copy(
                pwdConfirmInput = query,
                pwdConfirmError = it.pwdInput != query,
            )
        }
    }

    fun requestUpdatePwdChange() {
        flow {
            emit(updateUserPwdUseCase(inputState.value.pwdInput))
        }.onStart {
            _editUiState.value = EditUiState.Loading
        }.onEach {
            _editUiState.value = EditUiState.Success(UpdateType.PASSWORD)
        }.catch {
            _editUiState.value = EditUiState.Fail
        }.launchIn(viewModelScope)
    }

    fun resetUiState() {
        _editUiState.value = EditUiState.None
    }

    val logout: StateFlow<Boolean> = savedStateHandle.getStateFlow(LOG_OUT, false)
    fun handleLogout() {
        viewModelScope.launch {
            try {
                requestLogoutUseCase()
            } catch (e: Exception) {
                _editUiState.value = EditUiState.Fail
            }
        }.invokeOnCompletion {
            savedStateHandle[LOG_OUT] = true
        }
    }

}

private const val LOG_OUT = "logout"