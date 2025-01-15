package com.tenday.feature.edit.model

sealed interface EditUiState {
    data object None: EditUiState
    data object Loading: EditUiState
    data class Success(val update: UpdateType): EditUiState
    data object Fail: EditUiState
}

enum class UpdateType {
    PASSWORD,
    PROFILE_BADGE,
    PROFILE_IMAGE,
}