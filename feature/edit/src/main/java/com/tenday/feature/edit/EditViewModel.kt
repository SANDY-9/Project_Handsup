package com.tenday.feature.edit

import androidx.lifecycle.ViewModel
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileBadgeUseCase
import com.tenday.core.domain.usecases.user.UpdateProfileImageUseCase
import com.tenday.core.domain.usecases.user.UpdateUserPwdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class EditViewModel @Inject constructor(
    getUserDetailsUseCase: GetUserDetailsUseCase,
    private val updateUserPwdUseCase: UpdateUserPwdUseCase,
    private val updateProfileBadgeUseCase: UpdateProfileBadgeUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase,
): ViewModel() {
    init {
        getUserDetailsUseCase()
    }
}