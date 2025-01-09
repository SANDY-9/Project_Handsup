package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import javax.inject.Inject

class UpdateAccessTokenUseCase @Inject constructor(
    private val authPrefsRepository: AuthPrefsRepository
) {
    suspend operator fun invoke(token: String) {
        authPrefsRepository.updateAccessToken(token)
    }
}