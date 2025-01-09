package com.tenday.core.domain.usecases.board

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.BoardListRepository
import com.tenday.core.model.BoardDetails
import javax.inject.Inject

class GetBoardListUseCase @Inject constructor(
    private val boardListRepository: BoardListRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(): List<BoardDetails> {
        val accessToken = authPrefsRepository.getAccessToken() ?: ""
        return boardListRepository.getBoardList(accessToken)
    }
}