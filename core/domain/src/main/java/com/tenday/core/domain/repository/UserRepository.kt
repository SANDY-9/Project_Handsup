package com.tenday.core.domain.repository

import com.tenday.core.model.UserDetails

interface UserRepository {
    suspend fun getUserDetails(token: String): UserDetails
}