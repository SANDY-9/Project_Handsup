package com.tenday.feature.login.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tenday.feature.login.login.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

private const val ID_INPUT = "idInput"
private const val PWD_INPUT = "pwdInput"
@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    val idInput = savedStateHandle.getStateFlow(key = ID_INPUT, initialValue = "")
    val pwdInput = savedStateHandle.getStateFlow(key = PWD_INPUT, initialValue = "")

    private val _loginUiState = MutableStateFlow(LoginUiState.Ready)
    val loginUiState: StateFlow<LoginUiState> get() = _loginUiState

    fun onIdInputChanged(input: String) {
        savedStateHandle[ID_INPUT] = input
    }

    fun onPwdInputChanged(input: String) {
        savedStateHandle[PWD_INPUT] = input
    }

    fun requestLogin() {

    }

}

