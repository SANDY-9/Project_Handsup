package com.tenday.handsup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.tenday.feature.login.navigation.LoginRoute
import com.tenday.handsup.ui.bottomnav.HandsUpBottomNav

@Composable
fun HandsUpApp(
    appState: HandsUpAppState,
    startDestination: Any,
    isBoardLink: Boolean,
    onAppFinish: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomNavVisible = appState.isBottomNavVisible()
    Surface(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
            .navigationBarsPadding(),
        color = White,
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            HandsUpNavGraph(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f),
                navController = appState.navController,
                isBoardLink = isBoardLink,
                startDestination = startDestination,
                onAppFinish = onAppFinish,
            )
            if(bottomNavVisible) {
                HandsUpBottomNav(
                    onItemClick = appState::navigateToDestination,
                    currentDestination = appState.currentDestination,
                )
            }
        }
    }
}

@Preview(name = "HandsUpApp")
@Composable
private fun PreviewHandsUpApp() {
    HandsUpApp(
        HandsUpAppState(rememberNavController(), rememberCoroutineScope()),
        LoginRoute,
        false,
        {},
    )
}