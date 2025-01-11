package com.tenday.feature.mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.feature.mission.MissionRoute
import kotlinx.serialization.Serializable

@Serializable object MissionRoute

fun NavController.navigateToMission(
    navOptions: NavOptions,
) {
    navigate(route = MissionRoute, navOptions)
}

fun NavGraphBuilder.missionScreen() {
    composable<MissionRoute> {
        MissionRoute()
    }
}