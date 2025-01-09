package com.tenday.feature.board.model

import com.tenday.core.model.BoardDetails

internal sealed interface BoardUiState {
    data object Loading: BoardUiState
    data class Success(val data: List<BoardDetails>): BoardUiState
    data object Fail: BoardUiState
}