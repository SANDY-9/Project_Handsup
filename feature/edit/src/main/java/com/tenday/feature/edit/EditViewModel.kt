package com.tenday.feature.edit

import androidx.lifecycle.ViewModel
import com.tenday.core.domain.usecases.user.UpdateProfileBadgeUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileImageUseCase
import com.tenday.core.domain.usecases.user.UpdateUserPwdUseCase
import com.tenday.feature.edit.model.EditInputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class EditViewModel @Inject constructor(
    private val updateUserPwdUseCase: UpdateUserPwdUseCase,
    private val updateProfileBadgeUseCase: UpdateProfileBadgeUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase,
): ViewModel() {

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