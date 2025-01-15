package com.tenday.feature.edit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.model.UserDetails
import com.tenday.feature.edit.EditRoute
import kotlinx.serialization.Serializable

@Serializable object EditRoute

private const val USER_DETAILS = "user_details"

fun NavController.navigateToEdit(
    user: UserDetails,
    navOptions: NavOptions? = null,
) {
    currentBackStackEntry?.savedStateHandle?.set(USER_DETAILS, user)
    navigate(EditRoute, navOptions)
}

fun NavGraphBuilder.editScreen(
    navController: NavController,
    onNavigateBack: () -> Unit,
) {
    composable<EditRoute> {
        val user = navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<UserDetails>(USER_DETAILS)
            ?: return@composable
        EditRoute(
            user = user,
            onNavigateBack = onNavigateBack,
            onLogout = {}
        )
    }
}