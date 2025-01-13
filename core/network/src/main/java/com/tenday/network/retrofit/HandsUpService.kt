package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.Exp
import com.tenday.core.model.ExpDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.UserRequestBody
import com.tenday.network.model.UserResponse
import com.tenday.network.utils.toHeader
import javax.inject.Inject

internal class HandsUpService @Inject constructor(
    private val api: HandsUpServiceApi,
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

    override suspend fun getUserDetails(token: String): UserResponse {
        return api.getUserDetails(token.toHeader())
    }

    override suspend fun updateMessagingToken(
        accessToken: String,
        messagingToken: String,
    ): Boolean {
        val requestBody = UserRequestBody(fcmToken = messagingToken)
        return api.updateMessagingToken(requestBody, accessToken.toHeader()).isSuccess
    }

    override suspend fun getLastExpList(token: String): List<Exp> {
        return api.getExpDetails(token.toHeader()).expList.sortedBy { it.expAt }.takeLast(3)
    }

    override suspend fun getExpDetails(token: String): ExpDetails {
        return api.getExpDetails(token.toHeader())
    }
}