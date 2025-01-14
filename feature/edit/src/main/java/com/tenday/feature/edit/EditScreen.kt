package com.tenday.feature.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.theme.White
import com.tenday.feature.edit.components.EditTitleBar


@Composable
internal fun EditRoute(
    onNavigateBack: () -> Unit,
) {
    EditScreen(
        onNavigateBack = onNavigateBack
    )
}
@Composable
internal fun EditScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = White)
    ) {
        EditTitleBar(onNavigate = onNavigateBack)
    }
}

@Preview(name = "EditScreen")
@Composable
private fun PreviewEditScreen() {
    EditScreen({})

}