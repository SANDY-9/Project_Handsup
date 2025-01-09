package com.tenday.handsup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
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
        val splashNavOptions = navOptionBuilder.setPopUpTo<SplashRoute>(inclusive = true).build()
        splashScreen(
            onSplashShow = { token ->
                when(token) {
                    null -> navController.navigateToLogin(splashNavOptions)
                    else -> {

                    }
                }
            }
        )
        loginScreen()
    }
}