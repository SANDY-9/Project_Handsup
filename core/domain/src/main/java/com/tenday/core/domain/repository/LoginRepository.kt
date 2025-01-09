package com.tenday.core.domain.repository

interface LoginRepository {
    suspend fun requestLogin(id: String, pwd: String): String
}