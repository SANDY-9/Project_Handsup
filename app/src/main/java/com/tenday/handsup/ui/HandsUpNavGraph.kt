package com.tenday.handsup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import com.tenday.feature.board.details.navigation.boardDetailsScreen
import com.tenday.feature.board.details.navigation.navigateToBoardDetails
import com.tenday.feature.board.navigation.boardScreen
import com.tenday.feature.edit.navigation.editScreen
import com.tenday.feature.edit.navigation.navigateToEdit
import com.tenday.feature.exp.navigation.myExpScreen
import com.tenday.feature.home.navigation.homeScreen
import com.tenday.feature.home.navigation.navigateToHome
import com.tenday.feature.login.navigation.LoginRoute
import com.tenday.feature.login.navigation.loginScreen
import com.tenday.feature.login.navigation.navigateToLogin
import com.tenday.feature.mission.navigation.missionScreen
import com.tenday.feature.notification.navigation.navigateToNotification
import com.tenday.feature.notification.navigation.notificationScreen
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
                    else -> navController.navigateToHome(splashNavOptions)
                }
            }
        )

        val loginNavOptions = navOptionBuilder.setPopUpTo<LoginRoute>(inclusive = true).build()
        loginScreen(
            onSuccessLogin = {
                navController.navigateToHome(loginNavOptions)
            }
        )

        homeScreen(
            onNavigateNoti = navController::navigateToNotification,
            onNavigateEdit = navController::navigateToEdit,
        )

        missionScreen()

        myExpScreen()

        boardScreen(
            onNavigateNoti = navController::navigateToNotification,
            onCardClick = navController::navigateToBoardDetails,
        )

        boardDetailsScreen(
            navController = navController,
            onNavigateBack = navController::popBackStack,
        )

        notificationScreen(
            onNavigateBack = navController::popBackStack,
        )

        val logoutNavOptions = navOptionBuilder.setPopUpTo<LoginRoute>(
            inclusive = true
        ).setLaunchSingleTop(true).build()
        editScreen(
            navController = navController,
            onNavigateBack = navController::popBackStack,
            onLogout = {
                navController.navigateToLogin(logoutNavOptions)
            }
        )
    }
}