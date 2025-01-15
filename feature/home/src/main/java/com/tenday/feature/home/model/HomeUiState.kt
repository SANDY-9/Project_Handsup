package com.tenday.feature.home.model

import com.tenday.core.model.ExpDetails
import com.tenday.core.model.UserDetails

internal interface HomeUiState {
    data object Loading: HomeUiState
    data object Fail: HomeUiState
    data class Success(
        val expDetails: ExpDetails,
        val userDetails: UserDetails,
    ): HomeUiState
}