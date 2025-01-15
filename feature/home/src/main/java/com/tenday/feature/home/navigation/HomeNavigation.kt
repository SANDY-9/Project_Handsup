package com.tenday.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.common.enums.ExpType
import com.tenday.core.model.UserDetails
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
    onNavigateEdit: (UserDetails) -> Unit,
    onFinish: () -> Unit,
    onExpClick: (ExpType) -> Unit,
    onBannerClick: () -> Unit,
) {
    composable<HomeRoute> {
        HomeRoute(
            onNavigateNoti = onNavigateNoti,
            onNavigateEdit = onNavigateEdit,
            onFinish = onFinish,
            onExpClick = onExpClick,
            onBannerClick = onBannerClick,
        )
    }
}