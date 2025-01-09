package com.tenday.feature.board.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.model.BoardDetails
import com.tenday.feature.board.details.BoardDetailsRoute
import kotlinx.serialization.Serializable

@Serializable object BoardDetailsRoute

const val BOARD_DETAILS = "board_details"
fun NavController.navigateToBoardDetails(
    boardDetails: BoardDetails,
    navOptions: NavOptions? = null,
) {
    currentBackStackEntry?.savedStateHandle?.set(BOARD_DETAILS, boardDetails)
    navigate(route = BoardDetailsRoute, navOptions)
}

fun NavGraphBuilder.boardDetailsScreen(
    onNavigateBack: () -> Unit,
) {
    composable<BoardDetailsRoute> {
        BoardDetailsRoute(onNavigateBack)
    }
}