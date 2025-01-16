package com.tenday.core.data.repository

import com.tenday.core.domain.repository.LoginRepository
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class LoginRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource,
) : LoginRepository {
    override suspend fun requestLogin(id: String, pwd: String): String {
        return handsUpDataSource.login(id, pwd)
    }

    override suspend fun requestLogout(token: String) {
        handsUpDataSource.logout(token)
    }
}