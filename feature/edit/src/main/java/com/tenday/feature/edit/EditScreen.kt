package com.tenday.feature.edit

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
internal fun EditRoute() {
    EditScreen()
}
@Composable
internal fun EditScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "EditScreen")
    }
}

@Preview(name = "EditScreen")
@Composable
private fun PreviewEditScreen() {
    EditScreen()
}