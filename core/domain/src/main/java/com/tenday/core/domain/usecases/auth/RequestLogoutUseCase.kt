package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.LoginRepository
import javax.inject.Inject

class RequestLogoutUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke() {
        val token = authPrefsRepository.getAccessToken() ?: ""
        loginRepository.requestLogout(token)
        authPrefsRepository.deleteAccessToken()
    }
}