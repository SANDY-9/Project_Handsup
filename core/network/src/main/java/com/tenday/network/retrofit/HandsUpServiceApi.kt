package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails
import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

internal interface HandsUpServiceApi {
    @POST("login")
    suspend fun login(
        @Body requestBody: LoginRequestBody
    ): LoginResponse

    @GET("board")
    suspend fun getBoardList(
        @Header("Authorization") token: String,
    ): List<BoardDetails>
}