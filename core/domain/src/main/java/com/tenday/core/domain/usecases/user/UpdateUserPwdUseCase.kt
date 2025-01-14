package com.tenday.core.domain.usecases.user

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserPwdUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend fun invoke(pwd: String): Boolean {
        val token = authPrefsRepository.getAccessToken() ?: ""
        return userRepository.updateUserPwd(
            accessToken = token,
            pwd = pwd,
        )
    }
}