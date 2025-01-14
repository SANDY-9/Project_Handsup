package com.tenday.core.domain.usecases.user

import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.UserRepository
import javax.inject.Inject

class UpdateProfileBadgeUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend fun invoke(badgeCode: BadgeCode): Boolean {
        val token = authPrefsRepository.getAccessToken() ?: ""
        return userRepository.updateUserProfileBadge(
            accessToken = token,
            code = badgeCode,
        )
    }
}