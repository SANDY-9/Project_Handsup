package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.network.model.ExpResponse
import com.tenday.network.model.JobMissionResponse
import com.tenday.network.model.LeaderMissionResponse
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.PersonnelMissionResponse
import com.tenday.network.model.ProjectResponse
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

    override suspend fun getLastExpList(
        token: String,
        listSize: Int,
    ): ExpResponse {
        val expDetails = api.getExpDetails(token.toHeader())
        return api.getExpDetails(token.toHeader()).copy(
            expList = expDetails.expList.take(listSize)
        )
    }

    override suspend fun getExpDetails(token: String): ExpResponse {
        return api.getExpDetails(token.toHeader())
    }

    override suspend fun getLeaderMission(token: String): LeaderMissionResponse {
        return api.getLeaderMission(token.toHeader())
    }

    override suspend fun getJobMission(token: String): JobMissionResponse {
        return api.getJobMission(token.toHeader())
    }

    override suspend fun getProjectMission(token: String): List<ProjectResponse> {
        return api.getProjectMission(token.toHeader())
    }

    override suspend fun getPersonnelMission(token: String): List<PersonnelMissionResponse> {
        return api.getPersonnelMission(token.toHeader())
    }

    override suspend fun updateUserPwd(accessToken: String, pwd: String): Boolean {
        val requestBody = UserRequestBody(password = pwd)
        return api.updateUserPwd(requestBody, accessToken.toHeader()).isSuccess
    }

    override suspend fun updateUserProfileBadge(accessToken: String, code: String): Boolean {
        val requestBody = UserRequestBody(profileBadgeCode = code)
        return api.updateProfileBadge(requestBody, accessToken.toHeader()).isSuccess
    }

    override suspend fun updateUserProfileImage(accessToken: String, code: String): Boolean {
        val requestBody = UserRequestBody(profileImageCode = code)
        return api.updateProfileImage(requestBody, accessToken.toHeader()).isSuccess
    }
}