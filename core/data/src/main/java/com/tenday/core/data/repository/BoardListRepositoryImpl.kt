package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toBoardDetails
import com.tenday.core.domain.repository.BoardListRepository
import com.tenday.core.model.BoardDetails
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

class BoardListRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource
) : BoardListRepository {
    override suspend fun getBoardList(token: String): List<BoardDetails> {
        return handsUpDataSource.getBoardList(token).toBoardDetails()
    }

    override suspend fun updateReadCount(boardId: Int, token: String) {
        handsUpDataSource
    }
}