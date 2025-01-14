package com.tenday.feature.edit.model

import com.tenday.core.model.UserDetails

sealed interface EditUiState {
    data object Loading: EditUiState
    data class Success(val user: UserDetails): EditUiState
    data object Fail: EditUiState
}