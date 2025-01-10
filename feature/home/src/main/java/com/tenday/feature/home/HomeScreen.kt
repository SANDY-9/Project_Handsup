package com.tenday.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onNavigateNoti: () -> Unit,
) {
    HomeScreen(onNavigateNoti = onNavigateNoti)
}

@Composable
internal fun HomeScreen(
    onNavigateNoti: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.profile_background_field),
            contentDescription = null,
        )
        HomeTitleBar(onNavigateNoti)
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen({})
}