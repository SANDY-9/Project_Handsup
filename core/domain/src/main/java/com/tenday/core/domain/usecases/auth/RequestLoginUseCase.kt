package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.LoginRepository
import javax.inject.Inject

class RequestLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(id: String, pwd: String): String {
        return loginRepository.requestLogin(id, pwd)
    }
}