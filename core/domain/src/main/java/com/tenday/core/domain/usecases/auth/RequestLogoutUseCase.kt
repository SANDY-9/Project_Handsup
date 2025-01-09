package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import javax.inject.Inject

class RequestLogoutUseCase @Inject constructor(
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke() {
        authPrefsRepository.deleteAccessToken()
    }
}