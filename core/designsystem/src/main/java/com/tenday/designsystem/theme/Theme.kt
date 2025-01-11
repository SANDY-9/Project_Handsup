package com.tenday.designsystem.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val HandsUpColorScheme = lightColorScheme(
    primary = HandsUpOrange,
    background = White,
    surface = White,
    surfaceTint = White,
    onPrimary = Gray900,
    onBackground = Gray900,
    onSurface = Gray900,
)

@Composable
fun HandsUpTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> HandsUpColorScheme
        else -> HandsUpColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )

}

