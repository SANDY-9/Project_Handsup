package com.tenday.feature.board

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun BoardRoute(

) {
    BoardScreen()
}
@Composable
internal fun BoardScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text("게시판")
    }
}

@Preview(name = "BoardScreen")
@Composable
private fun PreviewBoardScreen() {
    BoardScreen()
}