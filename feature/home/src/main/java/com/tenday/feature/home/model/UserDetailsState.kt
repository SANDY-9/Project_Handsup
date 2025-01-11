package com.tenday.feature.home.model

import com.tenday.core.model.UserDetails

internal sealed interface UserDetailsState {
    data object Loading: UserDetailsState
    data class Success(val data: UserDetails): UserDetailsState
    data object Fail: UserDetailsState
}