package com.tenday.designsystem.utils

import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun StatusBarStyle(isDarkTheme: Boolean) {
    val activity = LocalContext.current as ComponentActivity
    LaunchedEffect(isDarkTheme) {
        activity.enableEdgeToEdge(
            // 상태바 텍스트 색상 - 화이트
            statusBarStyle = if(isDarkTheme) SystemBarStyle.dark(
                Color.TRANSPARENT,
            ) else {
                // 상태바 텍스트 색상 - 회색
                SystemBarStyle.light(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT,
                )
            },
        )
    }
}