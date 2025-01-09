package com.tenday.core.domain.usecases.board

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.GetBoardListRepository
import com.tenday.core.model.BoardDetails
import javax.inject.Inject

class GetBoardListUseCase @Inject constructor(
    private val getBoardListRepository: GetBoardListRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    suspend operator fun invoke(): List<BoardDetails> {
        val accessToken = authPrefsRepository.getAccessToken() ?: ""
        return getBoardListRepository.getBoardList(accessToken)
    }
}