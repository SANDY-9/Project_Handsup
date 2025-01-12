package com.tenday.feature.exp

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun ExpRoute() {
    ExpScreen()
}

@Composable
internal fun ExpScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "ExpScreen")
    }
}

@Preview(name = "ExpScreen")
@Composable
private fun PreviewExpScreen() {
    ExpScreen()
}