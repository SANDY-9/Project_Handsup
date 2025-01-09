package com.tenday.network.retrofit

interface HandsUpDataSource {
    suspend fun login(id: String, pwd: String): String
}