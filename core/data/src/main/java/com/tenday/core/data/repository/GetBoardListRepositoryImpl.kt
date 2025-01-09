package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toBoardDetails
import com.tenday.core.domain.repository.GetBoardListRepository
import com.tenday.core.model.BoardDetails
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

class GetBoardListRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource
) : GetBoardListRepository {
    override suspend fun getBoardList(): List<BoardDetails> {
        return handsUpDataSource.getBoardList().toBoardDetails()
    }
}