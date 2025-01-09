package com.tenday.feature.board.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tenday.core.model.BoardDetails
import com.tenday.designsystem.theme.White
import com.tenday.feature.board.details.components.BoardDetailsContentView
import com.tenday.feature.board.details.components.BoardDetailsTitleBar

@Composable
internal fun BoardDetailsRoute(
    boardDetails: BoardDetails,
    onNavigateBack: () -> Unit,
    viewModel: BoardDetailsViewModel = hiltViewModel(),
) {
   LaunchedEffect(boardDetails) {
       viewModel.updateReadCount(boardDetails)
   }
   BoardDetailsScreen(
       boardDetails = boardDetails,
       onNavigateBack = onNavigateBack,
   )
}

@Composable
internal fun BoardDetailsScreen(
    boardDetails: BoardDetails,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = White)
    ) {
        BoardDetailsTitleBar(onNavigate = onNavigateBack)
        BoardDetailsContentView(
            title = boardDetails.title,
            date = boardDetails.createdAt,
            content = boardDetails.content,
        )
    }
}

@Preview(name = "BoardDetailsScreen")
@Composable
private fun PreviewBoardDetailsScreen() {
    BoardDetailsScreen(BoardDetails(
        boardId = 1,
        content = "본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글본문테스트글",
        createdAt = "2025-01-07T17:17:00.980Z",
        title = "AAA 프로젝트 신설 (경험치 500 do, 신청 마감 ~10/31)",
        false
    ), {})
}