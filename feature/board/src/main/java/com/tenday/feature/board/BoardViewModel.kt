package com.tenday.feature.board

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.board.GetBoardListUseCase
import com.tenday.feature.board.model.BoardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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

}