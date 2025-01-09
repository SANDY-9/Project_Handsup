package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.LoginResponse
import com.tenday.network.model.NotificationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
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

}