package com.tenday.network.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestBody(
    val id: String,
    val password: String,
)

@Serializable
data class LoginResponse(
    val accessToken: String,
)