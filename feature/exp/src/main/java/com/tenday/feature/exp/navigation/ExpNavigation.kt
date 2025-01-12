package com.tenday.feature.exp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.exp.ExpRoute
import kotlinx.serialization.Serializable

@Serializable object ExpRoute

fun NavController.navigateToExp(navOptions: NavOptions) {
    navigate(ExpRoute, navOptions)
}

fun NavGraphBuilder.expScreen() {
    composable<ExpRoute> {
        ExpRoute()
    }
}