package com.tenday.core.domain.usecases.user

import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.UserRepository
import javax.inject.Inject

class UpdateProfileImageUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend fun invoke(profileCode: ProfileCode): Boolean {
        val token = authPrefsRepository.getAccessToken() ?: ""
        return userRepository.updateUserProfileImage(
            accessToken = token,
            code = profileCode,
        )
    }
}