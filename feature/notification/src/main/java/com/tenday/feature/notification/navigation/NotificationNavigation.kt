package com.tenday.feature.notification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.model.BoardDetails
import com.tenday.feature.notification.NotificationRoute
import kotlinx.serialization.Serializable

@Serializable
object NotificationRoute

fun NavController.navigateToNotification(
    navOptions: NavOptions? = null,
) {
    navigate(route = NotificationRoute, navOptions)
}
fun NavGraphBuilder.notificationScreen(
    onNavigateBack: () -> Unit,
) {
    composable<NotificationRoute> {
        NotificationRoute(onNavigateBack)
    }
}