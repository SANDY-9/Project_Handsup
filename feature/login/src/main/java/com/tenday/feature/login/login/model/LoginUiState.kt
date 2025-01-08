package com.tenday.feature.login.login.model

internal sealed interface LoginUiState {
    data object Ready: LoginUiState
    data object Loading: LoginUiState
    data object Success: LoginUiState
    data object Fail: LoginUiState
}
