package com.tenday.core.domain.repository

interface AuthPrefsRepository {
    suspend fun updateAccessToken(token: String)
    suspend fun getAccessToken(): String?
}