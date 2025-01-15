package com.tenday.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.login.LoginRoute
import kotlinx.serialization.Serializable

@Serializable object LoginRoute
fun NavController.navigateToLogin(navOptions: NavOptions) {
    navigate(route = LoginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onSuccessLogin: () -> Unit,
    onFinish: () -> Unit,
) {
    composable<LoginRoute> {
        LoginRoute(
            onSuccessLogin = onSuccessLogin,
            onFinish = onFinish,
        )
    }
}
