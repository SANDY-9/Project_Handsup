package com.tenday.feature.board.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens

@Composable
internal fun BoardContentView(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(horizontal = Dimens.margin20),
        contentPadding = PaddingValues(vertical = Dimens.margin20)
    ) {
        items(10) {
            BoardItemCard()
        }
    }
}

@Preview(name = "BoardContentView")
@Composable
private fun PreviewBoardContentView() {
    BoardContentView()
}