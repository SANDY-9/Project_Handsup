package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails

interface HandsUpDataSource {
    suspend fun login(id: String, pwd: String): String
    suspend fun getBoardList(): List<BoardDetails>
}