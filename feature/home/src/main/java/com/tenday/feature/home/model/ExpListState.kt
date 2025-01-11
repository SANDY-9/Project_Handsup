package com.tenday.feature.home.model

import com.tenday.core.model.UserDetails

internal sealed interface ExpListState {
    data object Loading: ExpListState
    data class Success(val data: UserDetails): ExpListState
    data object EmptyExp: ExpListState
    data object Fail: ExpListState
}