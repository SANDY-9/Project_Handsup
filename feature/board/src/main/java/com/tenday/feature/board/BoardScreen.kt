package com.tenday.feature.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.model.BoardDetails
import com.tenday.designsystem.theme.Backgroud
import com.tenday.feature.board.components.BoardContentView
import com.tenday.feature.board.components.BoardTitleTopBar

@Composable
internal fun BoardRoute(
    onNavigateAlarm: () -> Unit,
    onCardClick: (BoardDetails) -> Unit,
) {
    BoardScreen(
        boardItems = List(15){ details },
        onCardClick = onCardClick,
        onNavigateAlarm = onNavigateAlarm,
    )
}
@Composable
internal fun BoardScreen(
    boardItems: List<BoardDetails>,
    onCardClick: (BoardDetails) -> Unit,
    onNavigateAlarm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Backgroud),
    ) {
        BoardTitleTopBar(onNavigateAlarm)
        BoardContentView(boardItems, onCardClick)
    }
}

private val details = BoardDetails(
    3,
    "안녕하세요. 물류 자동화 프로젝트를 신설하고, 해당 프로젝트에 참여할 팀원을 모집합니다.   " +
            "[프로젝트 목표] 1. 작업 안녕하세요. 물류 자동화 프로젝트를 신설하고, " +
            "해당 프로젝트에 참여할 팀원을 모집합니다.   [프로젝트 목표] 1. 작업",
    "2024.01.14",
    "물류 자동화 프로젝트 신설 물류 자동화 프로젝트 신설 물류 자동화 " +
            "프로젝트 신설 물류 자동화 프로젝트 신설"
)

@Preview(name = "BoardScreen")
@Composable
private fun PreviewBoardScreen() {
    BoardScreen(List(15){ details }, {}, {})
}