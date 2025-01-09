package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val authPrefsRepository: AuthPrefsRepository
) {
    suspend operator fun invoke(): String? {
        return authPrefsRepository.getAccessToken()
    }
}