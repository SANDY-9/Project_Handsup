package com.tenday.handsup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tenday.feature.login.login.navigation.LoginRoute

@Composable
fun HandsUpApp(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier = Modifier
) {
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
                modifier = modifier.fillMaxSize().weight(1f),
                navController = navController,
                startDestination = startDestination
            )
        }
    }
}

@Preview(name = "HandsUpApp")
@Composable
private fun PreviewHandsUpApp() {
    HandsUpApp(rememberNavController(), LoginRoute)
}