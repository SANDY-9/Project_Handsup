package com.tenday.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun requestLogin(id: String, pwd: String): Flow<String>
}