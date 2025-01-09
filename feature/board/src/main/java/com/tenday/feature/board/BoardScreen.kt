package com.tenday.feature.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.theme.Backgroud
import com.tenday.feature.board.components.BoardContentView
import com.tenday.feature.board.components.BoardTitleTopBar

@Composable
internal fun BoardRoute(

) {
    BoardScreen()
}
@Composable
internal fun BoardScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Backgroud),
    ) {
        BoardTitleTopBar()
        BoardContentView()
    }
}

@Preview(name = "BoardScreen")
@Composable
private fun PreviewBoardScreen() {
    BoardScreen()
}