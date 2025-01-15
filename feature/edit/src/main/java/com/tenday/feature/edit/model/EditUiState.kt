package com.tenday.feature.edit.model

sealed interface EditUiState {
    data object Loading: EditUiState
    data object Fail: EditUiState
}