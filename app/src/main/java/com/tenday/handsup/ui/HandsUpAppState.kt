package com.tenday.handsup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.tenday.feature.board.navigation.BoardRoute
import com.tenday.feature.board.navigation.navigateToBoard
import com.tenday.feature.exp.navigation.MyExpRoute
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
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
        when(destination) {
            BottomNavDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
            BottomNavDestination.MISSION -> navController.navigateToMission(navOptions = topLevelNavOptions)
            BottomNavDestination.EXP -> navController.navigateToExp(topLevelNavOptions)
            BottomNavDestination.BOARD -> navController.navigateToBoard(topLevelNavOptions)
        }
    }

    @Composable
    fun isBottomNavVisible(): Boolean {
        val route = currentDestination?.route ?: ""
        return route in listOf(
            HomeRoute.javaClass.name,
            MissionRoute.javaClass.name,
            MyExpRoute.javaClass.name,
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