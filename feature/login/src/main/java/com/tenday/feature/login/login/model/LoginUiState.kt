package com.tenday.feature.login.login.model

internal sealed interface LoginUiState {
    data object Ready: LoginUiState
    data object Loading: LoginUiState
    data object EmptyValue: LoginUiState
    data class Success(val token: String): LoginUiState
    data object Fail: LoginUiState
}