package com.tenday.feature.board.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tenday.core.model.BoardDetails
import com.tenday.feature.board.BoardRoute
import kotlinx.serialization.Serializable

@Serializable
object BoardRoute
fun NavController.navigateToBoard(navOptions: NavOptions) = navigate(route = BoardRoute, navOptions)
fun NavGraphBuilder.boardScreen(
    onNavigateNoti: () -> Unit,
    onCardClick: (BoardDetails) -> Unit,
) {
    composable<BoardRoute> {
        BoardRoute(onNavigateNoti, onCardClick)
    }
}