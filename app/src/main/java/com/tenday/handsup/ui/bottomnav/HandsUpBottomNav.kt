package com.tenday.handsup.ui.bottomnav

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.BottomNavDivider
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import kotlin.reflect.KClass

@Composable
internal fun HandsUpBottomNav(
    onItemClick: (BottomNavDestination) -> Unit,
    currentDestination: NavDestination?,
    items: List<BottomNavDestination> = BottomNavDestination.entries,
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
            items.forEach { destination ->
                val selected = currentDestination.isCurrentRoute(destination.route)
                val color = if(selected) destination.selectedColor else destination.unselectedColor
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(destination) },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp),
                                painter = painterResource(destination.iconRes),
                                contentDescription = null,
                                tint = color,
                            )
                            Spacer(modifier = modifier.height(Dimens.margin4))
                            Text(
                                text = stringResource(destination.titleRes),
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

private fun NavDestination?.isCurrentRoute(route: KClass<*>) = this?.hasRoute(route) ?: false
