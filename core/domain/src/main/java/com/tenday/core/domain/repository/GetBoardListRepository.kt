package com.tenday.core.domain.repository

import com.tenday.core.model.BoardDetails

interface GetBoardListRepository {
    suspend fun getBoardList(token: String): List<BoardDetails>
}