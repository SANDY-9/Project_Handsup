package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.LoginRepository
import javax.inject.Inject

class RequestLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(id: String, pwd: String): String {
        val token = loginRepository.requestLogin(id, pwd)
        authPrefsRepository.updateAccessToken(token)
        return token
    }
}