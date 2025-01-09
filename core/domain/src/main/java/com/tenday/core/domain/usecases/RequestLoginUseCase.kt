package com.tenday.core.domain.usecases

import com.tenday.core.domain.repository.LoginRepository
import javax.inject.Inject

class RequestLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(id: String, pwd: String) {
        loginRepository.requestLogin(id, pwd)
    }
}