package com.tenday.network.retrofit

import com.tenday.core.model.BoardDetails

interface HandsUpDataSource {
    suspend fun login(id: String, pwd: String): String
    suspend fun getBoardList(token: String): List<BoardDetails>
    suspend fun updateBoardReadCount(boardId: Int, token: String)
}