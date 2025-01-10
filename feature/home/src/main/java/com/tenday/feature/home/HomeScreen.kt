package com.tenday.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.theme.Backgroud
import com.tenday.feature.home.components.HomeContentView
import com.tenday.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onNavigateNoti: () -> Unit,
) {
    HomeScreen(onNavigateNoti = onNavigateNoti)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun HomeScreen(
    onNavigateNoti: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Backgroud,
            )
    ) {
        stickyHeader {
            HomeTitleBar(onNavigateNoti)
        }
        item {
            Box {
                Image(
                    modifier = modifier
                        .fillMaxWidth()
                        .heightIn(208.dp, 208.dp),
                    painter = painterResource(R.drawable.profile_background_field),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
                HomeContentView()
            }
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen({})
}