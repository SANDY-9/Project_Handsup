package com.tenday.handsup.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.BottomNavDivider
import com.tenday.designsystem.theme.Gray400
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.home.navigation.HomeRoute
import com.tenday.handsup.R
import kotlin.reflect.KClass

@Composable
internal fun HandsUpBottomNav(
    onItemClick: (BottomNavItem) -> Unit,
    currentRoute: Any?,
    items: List<BottomNavItem> = BOTTOM_NAV_ITEMS,
    modifier: Modifier = Modifier,
) {
    Column {
        HorizontalDivider(color = BottomNavDivider)
        Row (
            modifier = modifier
                .background(color = White)
                .clip(RectangleShape)
                .height(57.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { navItem ->
                val selected = navItem.route == currentRoute
                val color = if(selected) navItem.selectedColor else navItem.unselectedColor
                BottomNavigationItem(
                    selected = selected,
                    onClick = {  },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp),
                                painter = painterResource(navItem.iconRes),
                                contentDescription = null,
                                tint = color,
                            )
                            Spacer(modifier = modifier.height(Dimens.margin4))
                            Text(
                                text = stringResource(navItem.titleRes),
                                style = HandsUpTypography.body4.copy(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                ),
                                color = color,
                            )
                        }
                    },
                )
            }
        }
    }
}

internal data class BottomNavItem(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
    val route: KClass<*>,
    val selectedColor: Color = HandsUpOrange,
    val unselectedColor: Color = Gray400,
)

private val BOTTOM_NAV_ITEMS = listOf(
    BottomNavItem(
        iconRes = R.drawable.botton_nav_my,
        titleRes = R.string.bottom_nav_my,
        route = HomeRoute::class,
    ),
    BottomNavItem(
        iconRes = R.drawable.botton_nav_mission,
        titleRes = R.string.bottom_nav_mission,
        route = HomeRoute::class,
    ),
    BottomNavItem(
        iconRes = R.drawable.botton_nav_exp,
        titleRes = R.string.bottom_nav_exp,
        route = HomeRoute::class,
    ),
    BottomNavItem(
        iconRes = R.drawable.botton_nav_board,
        titleRes = R.string.bottom_nav_board,
        route = HomeRoute::class,
    ),
)