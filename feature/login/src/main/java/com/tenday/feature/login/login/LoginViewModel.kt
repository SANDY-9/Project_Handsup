package com.tenday.feature.login.login

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.auth.RequestLoginUseCase
import com.tenday.feature.login.login.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ID_INPUT = "idInput"
private const val PWD_INPUT = "pwdInput"
@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val requestLoginUseCase: RequestLoginUseCase,
): ViewModel() {

    val idInput = savedStateHandle.getStateFlow(key = ID_INPUT, initialValue = "")
    val pwdInput = savedStateHandle.getStateFlow(key = PWD_INPUT, initialValue = "")

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Ready)
    val loginUiState: StateFlow<LoginUiState> get() = _loginUiState

    fun onIdInputChanged(input: String) {
        savedStateHandle[ID_INPUT] = input
    }

    fun onPwdInputChanged(input: String) {
        savedStateHandle[PWD_INPUT] = input
    }

    fun requestLogin() {
        val id = idInput.value
        val pwd = pwdInput.value
        if(id.isBlank() || pwd.isBlank()) {
            _loginUiState.value = LoginUiState.EmptyValue
            return
        }

        viewModelScope.launch {
            requestLoginUseCase(id, pwd).onStart {
                _loginUiState.value = LoginUiState.Loading
            }.catch {
                _loginUiState.value = LoginUiState.Fail
                Log.e("확인", "requestLogin: $it", )
            }.collectLatest { isSuccess ->
                Log.e("확인", "requestLogin: $isSuccess", )
                delay(200L)
                if(isSuccess) {
                    _loginUiState.value = LoginUiState.Success
                }
                else {
                    _loginUiState.value = LoginUiState.Fail
                }
            }
        }
    }

}

