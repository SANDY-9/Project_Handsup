package com.tenday.network.retrofit

import com.tenday.network.model.LoginRequestBody
import com.tenday.network.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface HandsUpServiceApi {
    @POST("login")
    suspend fun login(
        @Body requestBody: LoginRequestBody
    ): LoginResponse
}