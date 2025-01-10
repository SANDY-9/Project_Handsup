package com.tenday.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpTitleTopBar
import com.tenday.designsystem.icons.AlarmFill
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.theme.White
import com.tenday.feature.home.R

@Composable
internal fun HomeTitleBar(
    onNavigateNoti: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            modifier = modifier.matchParentSize().graphicsLayer(scaleY = -1f),
            painter = painterResource(R.drawable.profile_background_field),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Column {
            Spacer(modifier = modifier.statusBarsPadding())
            HandsUpTitleTopBar(
                content = {
                    Icon(
                        modifier = modifier.align(Alignment.CenterStart),
                        imageVector = Icons.HandsUpLogo,
                        contentDescription = null,
                        tint = White,
                    )
                    Icon(
                        modifier = modifier.align(Alignment.CenterEnd)
                            .clickable(onClick = onNavigateNoti),
                        imageVector = Icons.AlarmFill,
                        contentDescription = null,
                        tint = White,
                    )
                }
            )
        }
    }
}

@Preview(name = "HomeTitleBar", showBackground = true,)
@Composable
private fun PreviewHomeTitleBar() {
    HomeTitleBar({})
}