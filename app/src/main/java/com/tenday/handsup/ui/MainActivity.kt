package com.tenday.handsup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tenday.designsystem.theme.HandsUpTheme
import com.tenday.feature.splash.navigation.SplashRoute
import com.tenday.service.HandsUpMessagingService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isBoardLink = intent.getStringExtra(HandsUpMessagingService.NOTIFICATION_EXTRA)?.contains("게시") ?: false

        enableEdgeToEdge()
        setContent {
            val handsUpAppState = rememberHandsUpAppState()
            HandsUpTheme {
                HandsUpApp(
                    appState = handsUpAppState,
                    startDestination = SplashRoute,
                    isBoardLink = isBoardLink,
                    onAppFinish = ::finishAffinity,
                )
            }
        }
    }
}