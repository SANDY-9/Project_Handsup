package com.tenday.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.common.args.Args
import com.tenday.core.common.enums.BadgeCode
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
    navController: NavController,
    onNavigateNoti: () -> Unit,
    onNavigateEdit: (UserDetails) -> Unit,
    onFinish: () -> Unit,
    onExpClick: (String) -> Unit,
    onBannerClick: () -> Unit,
) {
    composable<HomeRoute> {
        val receivedBadge = navController.currentBackStackEntry
            ?.savedStateHandle
            ?.get<String>(Args.BADGE)
        HomeRoute(
            onNavigateNoti = onNavigateNoti,
            onNavigateEdit = onNavigateEdit,
            onFinish = onFinish,
            onExpClick = { onExpClick(it.name) },
            onBannerClick = onBannerClick,
            receivedBadge = BadgeCode.getBadge(receivedBadge ?: ""),
        )
    }
}