package com.tenday.core.data.repository

import com.tenday.core.datastore.HandsUpPrefsDataSource
import com.tenday.core.domain.repository.AuthPrefsRepository
import javax.inject.Inject

class AuthPrefsRepositoryImpl @Inject constructor(
    private val prefsDataSource: HandsUpPrefsDataSource
) : AuthPrefsRepository {
    override suspend fun updateAccessToken(token: String) {
        prefsDataSource.updateAccessToken(token)
    }

    override suspend fun getAccessToken(): String? {
        return prefsDataSource.getAccessToken()
    }
}