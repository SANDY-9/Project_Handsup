package com.tenday.feature.edit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun EditDialog(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "EditDialog")
    }
}

@Preview(name = "EditDialog")
@Composable
private fun PreviewEditDialog() {
    EditDialog()
}