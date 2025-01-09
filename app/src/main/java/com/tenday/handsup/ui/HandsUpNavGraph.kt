package com.tenday.handsup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tenday.feature.login.login.navigation.LoginRoute
import com.tenday.feature.login.login.navigation.loginScreen
import com.tenday.feature.login.login.navigation.navigateToLogin
import com.tenday.feature.splash.navigation.SplashRoute
import com.tenday.feature.splash.navigation.splashScreen

@Composable
fun HandsUpNavGraph(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        val navOptionBuilder = NavOptions.Builder()
        splashScreen(
            onSplashShow = { show ->
                if(!show) {
                    navController.navigateToLogin(
                        navOptionBuilder.setPopUpTo<SplashRoute>(inclusive = true).build()
                    )
                }
            }
        )
        loginScreen()
    }
}

@Preview(name = "HandsUpNavGraph")
@Composable
private fun PreviewMainNavGraph() {
    HandsUpNavGraph(rememberNavController(), LoginRoute)
}