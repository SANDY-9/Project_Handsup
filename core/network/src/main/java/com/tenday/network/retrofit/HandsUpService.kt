package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.network.model.LoginRequestBody
import javax.inject.Inject

internal class HandsUpService @Inject constructor(
    private val api: HandsUpServiceApi
): HandsUpDataSource {
    override suspend fun login(id: String, pwd: String): String {
        return api.login(
            LoginRequestBody(id = id, password = pwd)
        ).accessToken
    }

    override suspend fun getBoardList(): List<BoardDetails> {
        return api.getBoardList()
    }
}