package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.TransparentBlack70
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpDialog(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Column(
        modifier = modifier.fillMaxSize().background(
            color = TransparentBlack70,
        ).clickable(onClick = onCancel),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = modifier.background(
                color = White,
                shape = RoundedCornerShape(Dimens.cornerShape16),
            )
        ) {
            content.invoke(this)
        }
    }
}

@Preview(name = "Dialog")
@Composable
private fun PreviewDialog() {
    HandsUpDialog(
        onCancel = {},
    ) {

    }
}