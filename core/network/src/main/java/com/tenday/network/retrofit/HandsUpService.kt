package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.utils.toHeader
import javax.inject.Inject

internal class HandsUpService @Inject constructor(
    private val api: HandsUpServiceApi
): HandsUpDataSource {
    override suspend fun login(id: String, pwd: String): String {
        return api.login(
            LoginRequestBody(id = id, password = pwd)
        ).accessToken
    }

    override suspend fun getBoardList(token: String): List<BoardDetails> {
        return api.getBoardList(token.toHeader())
    }

    override suspend fun updateBoardReadCount(boardId: Int, token: String) {
        api.updateBoardReadCount(boardId, token.toHeader())
    }

    override suspend fun getNotificationList(token: String): List<NotificationDetails> {
        return api.getNotificationList(token.toHeader()).noticeList
    }
}