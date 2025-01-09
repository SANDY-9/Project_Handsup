package com.tenday.core.domain.repository

import com.tenday.core.model.BoardDetails

interface BoardListRepository {
    suspend fun getBoardList(token: String): List<BoardDetails>
    suspend fun updateReadCount(boardId: Int, token: String)
}