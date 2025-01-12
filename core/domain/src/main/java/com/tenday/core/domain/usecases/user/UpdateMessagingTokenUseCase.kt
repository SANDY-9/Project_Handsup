package com.tenday.core.domain.usecases.user

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.MessagingTokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UpdateMessagingTokenUseCase @Inject constructor(
    private val messagingTokenRepository: MessagingTokenRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    operator fun invoke(): Flow<Boolean> {
        return messagingTokenRepository.getMessagingToken().map { messagingToken ->
            val token = authPrefsRepository.getAccessToken() ?: ""
            messagingTokenRepository.updateMessagingToken(
                accessToken = token,
                messagingToken = messagingToken
            )
        }
    }
}