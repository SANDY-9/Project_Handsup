package com.tenday.handsup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tenday.designsystem.theme.HandsUpTheme
import com.tenday.feature.splash.navigation.SplashRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val handsUpAppState = rememberHandsUpAppState()
            HandsUpTheme {
                HandsUpApp(
                    appState = handsUpAppState,
                    startDestination = SplashRoute,
                    onAppFinish = ::finish
                )
            }
        }
    }
}