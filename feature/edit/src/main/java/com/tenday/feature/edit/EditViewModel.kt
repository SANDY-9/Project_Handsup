package com.tenday.feature.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.usecases.user.UpdateProfileBadgeUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileImageUseCase
import com.tenday.core.domain.usecases.user.UpdateUserPwdUseCase
import com.tenday.feature.edit.model.EditInputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
): ViewModel() {

    val notificationEnable = appPrefsRepository.getNotificationState().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = false,
    )

    fun updateNotifiChange(enable: Boolean) {
        viewModelScope.launch {
            appPrefsRepository.updateNotificationState(enable)
        }
    }

    private val _inputState = MutableStateFlow(
        EditInputState(
            pwdInput = "",
            pwdConfirmInput = "",
            pwdError = true,
            pwdConfirmError = true,
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

}