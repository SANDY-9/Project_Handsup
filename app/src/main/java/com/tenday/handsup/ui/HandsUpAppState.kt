package com.tenday.handsup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.tenday.feature.board.navigation.BoardRoute
import com.tenday.feature.board.navigation.navigateToBoard
import com.tenday.feature.exp.navigation.ExpRoute
import com.tenday.feature.exp.navigation.navigateToExp
import com.tenday.feature.home.navigation.HomeRoute
import com.tenday.feature.home.navigation.navigateToHome
import com.tenday.feature.mission.navigation.MissionRoute
import com.tenday.feature.mission.navigation.navigateToMission
import com.tenday.handsup.ui.bottomnav.BottomNavDestination
import kotlinx.coroutines.CoroutineScope

@Stable
class HandsUpAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            // Collect the currentBackStackEntryFlow as a state
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    fun navigateToDestination(destination: BottomNavDestination) {
        val navOption = NavOptions.Builder().build()
        when(destination) {
            BottomNavDestination.HOME -> navController.navigateToHome(navOption)
            BottomNavDestination.MISSION -> navController.navigateToMission(navOption)
            BottomNavDestination.EXP -> navController.navigateToExp(navOption)
            BottomNavDestination.BOARD -> navController.navigateToBoard(navOption)
        }
    }

    @Composable
    fun isBottomNavVisible(): Boolean {
        val route = currentDestination?.route ?: ""
        return route in listOf(
            HomeRoute.javaClass.name,
            MissionRoute.javaClass.name,
            ExpRoute.javaClass.name,
            BoardRoute.javaClass.name,
        )
    }
}

@Composable
fun rememberHandsUpAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): HandsUpAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        HandsUpAppState(
            navController,
            coroutineScope,
        )
    }
}