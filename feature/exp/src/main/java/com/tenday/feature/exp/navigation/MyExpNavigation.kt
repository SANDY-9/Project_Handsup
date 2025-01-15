package com.tenday.feature.exp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.exp.MyExpRoute
import kotlinx.serialization.Serializable

@Serializable object MyExpRoute

fun NavController.navigateToExp(
    navOptions: NavOptions? = null
) {
    navigate(MyExpRoute, navOptions)
}

fun NavGraphBuilder.myExpScreen() {
    composable<MyExpRoute> {
        MyExpRoute()
    }
}