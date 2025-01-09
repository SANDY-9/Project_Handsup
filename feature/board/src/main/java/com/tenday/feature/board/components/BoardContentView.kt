package com.tenday.feature.board.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.model.BoardDetails
import com.tenday.designsystem.dimens.Dimens

@Composable
internal fun BoardContentView(
    boardItems: List<BoardDetails>,
    onCardClick: (BoardDetails) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(horizontal = Dimens.margin20),
        contentPadding = PaddingValues(vertical = Dimens.margin20)
    ) {
        items(boardItems) { details->
            BoardItemCard(details, onCardClick)
        }
    }
}

@Preview(name = "BoardContentView")
@Composable
private fun PreviewBoardContentView() {
    val item = BoardDetails(
        3,
        "안녕하세요. 물류 자동화 프로젝트를 신설하고, 해당 프로젝트에 참여할 팀원을 모집합니다.   " +
                "[프로젝트 목표] 1. 작업 안녕하세요. 물류 자동화 프로젝트를 신설하고, " +
                "해당 프로젝트에 참여할 팀원을 모집합니다.   [프로젝트 목표] 1. 작업",
        "2024.01.14",
        "물류 자동화 프로젝트 신설 물류 자동화 프로젝트 신설 물류 자동화 " +
                "프로젝트 신설 물류 자동화 프로젝트 신설",
        false
    )
    BoardContentView(
        List(30) { item },
        {}
    )
}