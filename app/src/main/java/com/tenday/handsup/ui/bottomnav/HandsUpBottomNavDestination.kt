package com.tenday.handsup.ui.bottomnav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.tenday.designsystem.theme.Gray400
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.feature.board.navigation.BoardRoute
import com.tenday.feature.home.navigation.HomeRoute
import com.tenday.feature.login.login.navigation.LoginRoute
import com.tenday.handsup.R
import kotlin.reflect.KClass

enum class BottomNavDestination(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
    val route: KClass<*>,
    val selectedColor: Color = HandsUpOrange,
    val unselectedColor: Color = Gray400,
) {
    HOME(
        iconRes = R.drawable.botton_nav_my,
        titleRes = R.string.bottom_nav_my,
        route = HomeRoute::class,
    ),
    MISSION(
        iconRes = R.drawable.botton_nav_mission,
        titleRes = R.string.bottom_nav_mission,
        route = LoginRoute::class,
    ),
    EXP(
        iconRes = R.drawable.botton_nav_exp,
        titleRes = R.string.bottom_nav_exp,
        route = LoginRoute::class,
    ),
    BOARD(
        iconRes = R.drawable.botton_nav_board,
        titleRes = R.string.bottom_nav_board,
        route = BoardRoute::class,
    )
}