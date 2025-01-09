package com.tenday.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
internal fun SplashRoute(
    onAccessToken: (String?) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val splashShow by viewModel.splashShow.collectAsStateWithLifecycle()
    LaunchedEffect(splashShow) {
        if(!splashShow) {
            val accessToken = viewModel.getAccessToken()
            onAccessToken(accessToken)
        }
    }
    SplashScreen()
}

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize().background(
            color = HandsUpOrange
        ),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = modifier.fillMaxHeight(0.38f))
            Icon(
                modifier = modifier.size(width = 200.dp, height = 30.dp),
                imageVector = Icons.HandsUpLogo,
                contentDescription = null,
                tint = White,
            )
            Spacer(modifier = modifier.height(Dimens.margin20))
            Text(
                text = stringResource(R.string.app_desc),
                style = HandsUpTypography.title5.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = White,
            )
        }
    }
}

@Preview(name = "SplashScreen")
@Composable
private fun PreviewSplashScreen() {
    SplashScreen()
}