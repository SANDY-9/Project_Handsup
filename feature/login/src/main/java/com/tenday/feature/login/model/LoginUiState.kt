package com.tenday.feature.login.model

internal sealed interface LoginUiState {
    data object Ready: LoginUiState
    data object Loading: LoginUiState
    data object EmptyValue: LoginUiState
    data object Success: LoginUiState
    data object Fail: LoginUiState

    companion object {
        fun LoginUiState.error() = this is EmptyValue || this is Fail
        fun LoginUiState.enabled() = this !is Loading
        fun LoginUiState.loading() = this is Loading
    }
}
