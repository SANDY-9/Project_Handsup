package com.tenday.feature.board.details.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpNavigateTopBar
import com.tenday.feature.board.details.R

@Composable
internal fun BoardDetailsTitleBar(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpNavigateTopBar(
        title = stringResource(R.string.board_details_title),
        onNavigate = onNavigate
    )
}

@Preview(name = "BoardDetailsTitleBar")
@Composable
private fun PreviewBoardDetailsTitleBar() {
    BoardDetailsTitleBar({})
}