package com.tenday.feature.splash

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.designsystem.utils.StatusBarStyle
import kotlinx.coroutines.delay

@Composable
internal fun SplashRoute(
    onAccessToken: (String?) -> Unit,
    onFinish: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    BackHandler(enabled = true) {
        onFinish()
    }
    StatusBarStyle(true)
    var showText by remember { mutableStateOf(false) }
    var showLogo by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(500)
        showText = true
        delay(1000)
        showLogo = true
        showText = false
        delay(500)
        showLogo = false
        delay(600)
        val accessToken = viewModel.getAccessToken()
        onAccessToken(accessToken)
    }
    SplashScreen(
        textVisible = showText,
        logoVisible = showLogo,
    )
}

@Composable
internal fun SplashScreen(
    textVisible: Boolean,
    logoVisible: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(
            color = HandsUpOrange
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = modifier.fillMaxHeight(0.38f))
        Column (
            modifier = modifier.height(90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AnimatedVisibility(
                visible = logoVisible,
                enter = fadeIn() + expandIn(
                    expandFrom = Alignment.TopCenter,
                    clip = false,
                ),
                exit = fadeOut(animationSpec = tween(durationMillis = 1000))
            ) {
                Icon(
                    modifier = modifier.size(
                        width = 200.dp,
                        height = 30.dp
                    ),
                    imageVector = Icons.HandsUpLogo,
                    contentDescription = null,
                    tint = White,
                )
            }

            AnimatedVisibility(
                visible = textVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 500)),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.app_desc1),
                        style = HandsUpTypography.title5.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                        ),
                        color = White,
                    )
                    Text(
                        text = stringResource(R.string.app_desc2),
                        style = HandsUpTypography.title5.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                        ),
                        color = White,
                    )
                }
            }
        }
    }
}

@Preview(name = "SplashScreen")
@Composable
private fun PreviewSplashScreen() {
    var textShow by remember { mutableStateOf(true) }
    LaunchedEffect(textShow) {
        delay(1000L)
        textShow = false
    }
    SplashScreen(
        textShow,
        !textShow,
    )
}