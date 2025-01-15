package com.tenday.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthPrefsRepository {
    suspend fun updateAccessToken(token: String)
    suspend fun getAccessToken(): String?
    suspend fun deleteAccessToken()
    fun getNotificationState(): Flow<Boolean>
    suspend fun updateNotificationState(enable: Boolean)
}