package com.tenday.core.domain.usecases.board

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.BoardListRepository
import javax.inject.Inject

class UpdateBoardReadCountUseCase @Inject constructor(
    private val boardListRepository: BoardListRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(boardId: Int) {
        val accessToken = authPrefsRepository.getAccessToken() ?: ""
        boardListRepository.updateReadCount(boardId, accessToken)
    }
}