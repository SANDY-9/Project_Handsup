package com.tenday.feature.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.splash.SplashRoute
import kotlinx.serialization.Serializable

@Serializable object SplashRoute

fun NavController.navigateToSplash(navOptions: NavOptions) = navigate(route = SplashRoute, navOptions)

fun NavGraphBuilder.splashScreen(
    onSplashShow: (String?) -> Unit,
) {
    composable<SplashRoute> {
        SplashRoute(onSplashShow)
    }
}