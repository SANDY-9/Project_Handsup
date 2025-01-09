package com.tenday.feature.board

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.board.GetBoardListUseCase
import com.tenday.core.model.BoardDetails
import com.tenday.feature.board.model.BoardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class BoardViewModel @Inject constructor(
    private val getBoardListUseCase: GetBoardListUseCase,
): ViewModel() {

    private val _boardUiState = MutableStateFlow<BoardUiState>(BoardUiState.Loading)
    val boardUiState: StateFlow<BoardUiState> get() = _boardUiState

    init {
        flow {
            emit(getBoardListUseCase())
        }.onEach { data ->
            _boardUiState.value = BoardUiState.Success(data)
        }.catch {
            _boardUiState.value = BoardUiState.Fail
        }.launchIn(viewModelScope)
    }

    fun onBoardItemClick(boardDetails: BoardDetails) {
        if(!boardDetails.isRead) {
            updateItemReadState(boardDetails)
        }
    }

    private fun updateItemReadState(boardDetails: BoardDetails) {
        val currentState = _boardUiState.value
        if (currentState is BoardUiState.Success) {
            val updatedList = currentState.data.map { item ->
                if (item == boardDetails) {
                    item.copy(isRead = true) // isRead 값을 true로 변경
                } else {
                    item
                }
            }
            _boardUiState.value = BoardUiState.Success(updatedList)
        }
    }

}