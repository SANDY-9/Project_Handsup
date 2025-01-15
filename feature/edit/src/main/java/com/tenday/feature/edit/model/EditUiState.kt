package com.tenday.feature.edit.model

internal sealed interface EditUiState {
    data object None: EditUiState
    data object Loading: EditUiState
    data class Success(val update: UpdateType): EditUiState
    data object Fail: EditUiState
}

internal enum class UpdateType(val desc: String) {
    PASSWORD("비밀번호"),
    PROFILE_BADGE("프로필 배지"),
    PROFILE_IMAGE("프로필 이미지"),
}