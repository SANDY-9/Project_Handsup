package com.tenday.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute
fun NavController.navigateToHome(
    navOptions: NavOptions,
) {
    navigate(route = HomeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onNavigateNoti: () -> Unit,
    onNavigateSettings: () -> Unit,
) {
    composable<HomeRoute> {
        HomeRoute(
            onNavigateNoti = onNavigateNoti,
            onNavigateSettings = onNavigateSettings,
        )
    }
}