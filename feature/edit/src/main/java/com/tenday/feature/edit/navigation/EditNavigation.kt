package com.tenday.feature.edit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.edit.EditRoute
import kotlinx.serialization.Serializable

@Serializable object EditRoute

fun NavController.navigateToEdit(
    navOptions: NavOptions? = null,
) {
    navigate(EditRoute, navOptions)
}

fun NavGraphBuilder.editScreen(
    onNavigateBack: () -> Unit,
) {
    composable<EditRoute> {
        EditRoute(
            onNavigateBack = onNavigateBack,
            onLogout = {}
        )
    }
}