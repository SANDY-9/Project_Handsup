package com.tenday.core.data.repository

import com.tenday.core.domain.repository.MessagingTokenRepository
import com.tenday.network.firebase.MessagingTokenManager
import com.tenday.network.retrofit.HandsUpDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MessagingTokenRepositoryImpl @Inject constructor(
    private val messagingTokenManager: MessagingTokenManager,
    private val handsUpDataSource: HandsUpDataSource,
) : MessagingTokenRepository {
    override fun getMessagingToken(): Flow<String> {
        return messagingTokenManager.getMessagingToken()
    }
    override suspend fun updateMessagingToken(
        accessToken: String, messagingToken: String
    ): Boolean {
        return handsUpDataSource.updateMessagingToken(
            accessToken = accessToken,
            messagingToken = messagingToken
        )
    }
}