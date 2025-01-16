package com.tenday.feature.mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.common.enums.ExpType
import com.tenday.feature.mission.MissionRoute
import kotlinx.serialization.Serializable

@Serializable object MissionRoute

const val EXP_TYPE = "exp_type"

fun NavController.navigateToMission(
    expType: String = ExpType.L.name,
    navOptions: NavOptions? = null,
) {
    currentBackStackEntry?.savedStateHandle?.set(EXP_TYPE, expType)
    navigate(route = MissionRoute, navOptions)
}

fun NavGraphBuilder.missionScreen(
    navController: NavController,
) {
    composable<MissionRoute> {
        val expType = navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<String>(EXP_TYPE)
            ?: ""
        MissionRoute(expType)
    }
}