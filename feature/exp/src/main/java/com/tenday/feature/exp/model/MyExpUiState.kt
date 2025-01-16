package com.tenday.feature.exp.model

import com.tenday.core.model.ExpDetails
import com.tenday.core.model.UserDetails

internal interface MyExpUiState {
    data object Loading: MyExpUiState
    data object Fail: MyExpUiState
    data class Success(
        val expDetails: ExpDetails,
        val userDetails: UserDetails,
    ): MyExpUiState
}