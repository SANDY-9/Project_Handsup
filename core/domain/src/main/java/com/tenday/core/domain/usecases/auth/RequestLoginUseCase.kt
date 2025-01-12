package com.tenday.core.domain.usecases.auth

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.LoginRepository
import com.tenday.core.domain.repository.MessagingTokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RequestLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authPrefsRepository: AuthPrefsRepository,
    private val messagingTokenRepository: MessagingTokenRepository,
) {
    suspend operator fun invoke(id: String, pwd: String): Flow<Boolean> {
        val accessToken = loginRepository.requestLogin(id, pwd)
        authPrefsRepository.updateAccessToken(accessToken)
        return messagingTokenRepository.getMessagingToken().map { messagingToken ->
            messagingTokenRepository.updateMessagingToken(
                accessToken = accessToken,
                messagingToken = messagingToken
            )
        }
    }
}