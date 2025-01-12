package com.tenday.core.domain.usecases.user

import android.util.Log
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.MessagingTokenRepository
import javax.inject.Inject

class UpdateMessagingTokenUseCase @Inject constructor(
    private val messagingTokenRepository: MessagingTokenRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(messagingToken: String): Boolean {
        val token = authPrefsRepository.getAccessToken() ?: ""
        Log.e("확인", "invoke: 메시징 : $messagingToken", )
        Log.e("확인", "invoke: 어세스 : $token", )
        return messagingTokenRepository.updateMessagingToken(
            accessToken = token,
            messagingToken = messagingToken
        )
    }
}