package com.tenday.feature.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.core.model.BoardDetails
import com.tenday.designsystem.theme.Backgroud
import com.tenday.feature.board.components.BoardContentView
import com.tenday.feature.board.components.BoardTitleTopBar
import com.tenday.feature.board.model.BoardUiState

@Composable
internal fun BoardRoute(
    onNavigateNoti: () -> Unit,
    onCardClick: (BoardDetails) -> Unit,
    viewModel: BoardViewModel = hiltViewModel(),
) {
    val boardUiState by viewModel.boardUiState.collectAsStateWithLifecycle()
    BoardScreen(
        boardUiState = boardUiState,
        onCardClick = { item ->
            viewModel.onBoardItemClick(item)
            onCardClick(item)
        },
        onNavigateNoti = onNavigateNoti,
    )
}
@Composable
internal fun BoardScreen(
    boardUiState: BoardUiState,
    onCardClick: (BoardDetails) -> Unit,
    onNavigateNoti: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Backgroud),
    ) {
        BoardTitleTopBar(onNavigateNoti)
        when(boardUiState) {
            is BoardUiState.Success -> BoardContentView(
                boardItems = boardUiState.data,
                onCardClick = onCardClick
            )
            else -> {}
        }
    }
}

@Preview(name = "BoardScreen")
@Composable
private fun PreviewBoardScreen() {
    BoardScreen(BoardUiState.Loading, {}, {})
}