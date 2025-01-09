package com.tenday.feature.board.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpTitleTopBar
import com.tenday.designsystem.icons.Alarm
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.board.R

@Composable
internal fun BoardTitleTopBar(
    onNavigateNoti: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier.background(White)
    ) {
        Spacer(modifier = modifier.systemBarsPadding())
        HandsUpTitleTopBar(
            content = {
                Text(
                    modifier = modifier.align(Alignment.CenterStart),
                    text = stringResource(R.string.board_title),
                    style = HandsUpTypography.title3
                )
                Icon(
                    modifier = modifier.align(Alignment.CenterEnd)
                        .size(24.dp)
                        .clickable(onClick = onNavigateNoti)
                    ,
                    imageVector = Icons.Alarm,
                    contentDescription = null,
                    tint = Gray600,
                )
            }
        )
        HorizontalDivider(color = Gray100)
    }
}

@Preview
@Composable
private fun Preview() {
    BoardTitleTopBar({})
}