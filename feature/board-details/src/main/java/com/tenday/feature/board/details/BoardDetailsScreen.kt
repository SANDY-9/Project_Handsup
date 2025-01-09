package com.tenday.feature.board.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.theme.White
import com.tenday.feature.board.details.components.BoardDetailsContentView
import com.tenday.feature.board.details.components.BoardDetailsTitleBar

@Composable
fun BoardDetailsScreen(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = White)
    ) {
        BoardDetailsTitleBar(onNavigate = onNavigate)
        BoardDetailsContentView()
    }
}

@Preview(name = "BoardDetailsScreen")
@Composable
private fun PreviewBoardDetailsScreen() {
    BoardDetailsScreen({})
}