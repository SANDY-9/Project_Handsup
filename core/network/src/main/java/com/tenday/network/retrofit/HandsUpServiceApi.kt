package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.network.model.ExpResponse
import com.tenday.network.model.JobMissionResponse
import com.tenday.network.model.LeaderMissionResponse
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.LoginResponse
import com.tenday.network.model.NotificationResponse
import com.tenday.network.model.PersonnelMissionResponse
import com.tenday.network.model.ProjectResponse
import com.tenday.network.model.UserRequestBody
import com.tenday.network.model.UserResponse
import com.tenday.network.model.UserUpdateResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

internal interface HandsUpServiceApi {
    @POST("login")
    suspend fun login(
        @Body requestBody: LoginRequestBody
    ): LoginResponse

    @GET("board")
    suspend fun getBoardList(
        @Header("Authorization") token: String,
    ): List<BoardDetails>

    @POST("board/{boardId}/read")
    suspend fun updateBoardReadCount(
        @Path("boardId") boardId: Int,
        @Header("Authorization") token: String,
    )

    @GET("notice")
    suspend fun getNotificationList(
        @Header("Authorization") token: String,
    ): NotificationResponse

    @GET("user")
    suspend fun getUserDetails(
        @Header("Authorization") token: String,
    ): UserResponse

    @PATCH("user/fcm_token")
    suspend fun updateMessagingToken(
        @Body requestBody: UserRequestBody,
        @Header("Authorization") token: String,
    ): UserUpdateResponse

    @GET("exp/status")
    suspend fun getExpDetails(
        @Header("Authorization") token: String,
    ): ExpResponse

    @GET("exp/leader-quest")
    suspend fun getLeaderMission(
        @Header("Authorization") token: String,
    ): LeaderMissionResponse

    @GET("exp/job-quest")
    suspend fun getJobMission(
        @Header("Authorization") token: String,
    ): JobMissionResponse

    @GET("exp/company-quest")
    suspend fun getProjectMission(
        @Header("Authorization") token: String,
    ): List<ProjectResponse>

    @GET("exp/performance")
    suspend fun getPersonnelMission(
        @Header("Authorization") token: String,
    ): List<PersonnelMissionResponse>

}