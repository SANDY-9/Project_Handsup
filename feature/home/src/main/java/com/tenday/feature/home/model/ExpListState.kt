package com.tenday.feature.home.model

import com.tenday.core.model.Exp

internal sealed interface ExpListState {
    data object Loading: ExpListState
    data class Success(val data: List<Exp>): ExpListState
    data object EmptyExp: ExpListState
    data object Fail: ExpListState
}