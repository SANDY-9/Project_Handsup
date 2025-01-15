package com.tenday.feature.home.model

import com.tenday.core.model.Exp
import com.tenday.core.model.UserDetails

internal interface HomeUiState {
    data object Loading: HomeUiState
    data object Fail: HomeUiState
    data class Success(
        val expList: List<Exp>,
        val userDetails: UserDetails,
    ): HomeUiState
}