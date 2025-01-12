package com.tenday.feature.exp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.feature.exp.components.MyExpProfile

@Composable
internal fun MyExpRoute() {
    MyExpScreen()
}

@Composable
internal fun MyExpScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            MyExpProfile("F2-Ⅱ", currentValue = 14000,)
        }
    }
}

@Preview(name = "ExpScreen")
@Composable
private fun PreviewExpScreen() {
    MyExpScreen()
}