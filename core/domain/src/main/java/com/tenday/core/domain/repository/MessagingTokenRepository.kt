package com.tenday.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface MessagingTokenRepository {
    fun getMessagingToken(): Flow<String>
    suspend fun updateMessagingToken(accessToken: String, messagingToken: String): Boolean
}