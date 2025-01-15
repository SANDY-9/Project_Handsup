package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.network.model.ExpResponse
import com.tenday.network.model.JobMissionResponse
import com.tenday.network.model.LeaderMissionResponse
import com.tenday.network.model.PersonnelMissionResponse
import com.tenday.network.model.ProjectResponse
import com.tenday.network.model.UserResponse

interface HandsUpDataSource {
    suspend fun login(id: String, pwd: String): String
    suspend fun getBoardList(token: String): List<BoardDetails>
    suspend fun updateBoardReadCount(boardId: Int, token: String)
    suspend fun getNotificationList(token: String): List<NotificationDetails>
    suspend fun getUserDetails(token: String): UserResponse
    suspend fun updateMessagingToken(accessToken: String, messagingToken: String): Boolean
    suspend fun getLastExpList(token: String, listSize: Int): ExpResponse
    suspend fun getExpDetails(token: String): ExpResponse
    suspend fun getLeaderMission(token: String): LeaderMissionResponse
    suspend fun getJobMission(token: String): JobMissionResponse
    suspend fun getProjectMission(token: String): List<ProjectResponse>
    suspend fun getPersonnelMission(token: String): List<PersonnelMissionResponse>
    suspend fun updateUserPwd(accessToken: String, pwd: String): Boolean
    suspend fun updateUserProfileBadge(accessToken: String, code: String): Boolean
    suspend fun updateUserProfileImage(accessToken: String, code: String): Boolean
}