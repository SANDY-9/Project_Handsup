package com.tenday.feature.board.components
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.model.BoardDetails
import com.tenday.core.model.BoardDetails.Companion.getRemoveEnter
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.LightGray100
import com.tenday.designsystem.theme.LightGray200
import com.tenday.designsystem.theme.LightGray300

@Composable
fun BoardItemCard(
    boardDetails: BoardDetails,
    onCardClick: (BoardDetails) -> Unit,
    modifier: Modifier = Modifier,
) {
    HandsUpShadowCard(
        elevationSize = Dimens.cornerShape4,
        offsetY = 2.dp,
        shadowColor = CardShadowLight,
        clickable = true,
        onClick = { onCardClick(boardDetails) },
        content = {
            when {
                boardDetails.isRead -> ReadBoardItem(boardDetails)
                else -> NotReadBoardItem(boardDetails)
            }
        }
    )
    Spacer(modifier = modifier.height(Dimens.margin12))
}

@Composable
private fun NotReadBoardItem(
    boardDetails: BoardDetails,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(Dimens.margin16)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.weight(1f),
                text = boardDetails.title,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = boardDetails.createdAt,
                color = Gray600,
                style = HandsUpTypography.body4,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            text = boardDetails.content.getRemoveEnter(),
            color = Gray700,
            style = HandsUpTypography.body3,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun ReadBoardItem(
    boardDetails: BoardDetails,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(Dimens.margin16)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.weight(1f),
                text = boardDetails.title,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = LightGray300,
            )
            Text(
                text = boardDetails.createdAt,
                color = LightGray100,
                style = HandsUpTypography.body4,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            text = boardDetails.content.getRemoveEnter(),
            color = LightGray200,
            style = HandsUpTypography.body3,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(name = "BoardItemCard")
@Composable
private fun PreviewBoardItemCard() {
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        BoardItemCard(
            BoardDetails(
                3,
                "안녕하세요. 물류 자동화 프로젝트를 신설하고, 해당 프로젝트에 참여할 팀원을 모집합니다.   " +
                        "[프로젝트 목표] 1. 작업 안녕하세요. 물류 자동화 프로젝트를 신설하고, " +
                        "해당 프로젝트에 참여할 팀원을 모집합니다.   [프로젝트 목표] 1. 작업",
                "2024.01.14",
                "물류 자동화 프로젝트 신설 물류 자동화 프로젝트 신설 물류 자동화 " +
                        "프로젝트 신설 물류 자동화 프로젝트 신설",
                false
            ),
            {}
        )
    }
}