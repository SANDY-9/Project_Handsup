package com.tenday.core.domain.usecases.user

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.UserRepository
import com.tenday.core.model.UserDetails
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(): UserDetails {
        val accessToken = authPrefsRepository.getAccessToken() ?: ""
        return userRepository.getUserDetails(accessToken)
    }

}