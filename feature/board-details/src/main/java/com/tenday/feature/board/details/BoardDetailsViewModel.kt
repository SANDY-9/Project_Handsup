package com.tenday.feature.board.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tenday.core.domain.usecases.board.UpdateBoardReadCountUseCase
import com.tenday.core.model.BoardDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BoardDetailsViewModel @Inject constructor(
    private val updateBoardReadCountUseCase: UpdateBoardReadCountUseCase,
): ViewModel() {

    suspend fun updateReadCount(boardDetails: BoardDetails) {
        if(!boardDetails.isRead) {
            updateBoardReadCountUseCase(boardDetails.boardId)
        }
    }

}