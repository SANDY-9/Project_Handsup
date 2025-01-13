package com.tenday.feature.exp.model

import com.tenday.core.model.ExpDetails

sealed interface MyExpState {
    data object Loading: MyExpState
    data class Success(val data: ExpDetails): MyExpState
    data object Fail: MyExpState
}