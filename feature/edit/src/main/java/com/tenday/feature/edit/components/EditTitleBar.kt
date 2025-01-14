package com.tenday.feature.edit.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpNavigateTopBar
import com.tenday.feature.edit.R

@Composable
internal fun EditTitleBar(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpNavigateTopBar(
        title = stringResource(R.string.edit_title),
        onNavigate = onNavigate
    )
}

@Preview(name = "EditTitleBar")
@Composable
private fun PreviewEditTitleBar() {
    EditTitleBar({})
}