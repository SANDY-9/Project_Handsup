package com.tenday.feature.board.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray200
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
fun BoardDetailsContentView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(vertical = Dimens.margin16)
    ) {
        Text(
            modifier = modifier.fillMaxWidth().padding(horizontal = Dimens.margin20),
            text = "물류 자동화 프로젝트 물류 자동화 프로젝트 물류 자동화 프로젝트 물류 자동화 프로젝트 물류 자동화 프로젝트 물류 자동화 프로젝트 ",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            modifier = modifier.padding(horizontal = Dimens.margin20),
            text = "2025.01.14",
            style = HandsUpTypography.body2,
            color = Gray600
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
        HorizontalDivider(color = Gray200)
        LazyColumn(
            modifier = modifier.padding(
                horizontal = Dimens.margin20,
                vertical = Dimens.margin16,
            )
        ) {
            item {
                Text("내용이 들어감")
            }
        }
    }
}

@Preview(name = "BoardDetailsContentView")
@Composable
private fun PreviewBoardDetailsContentView() {
    BoardDetailsContentView()
}