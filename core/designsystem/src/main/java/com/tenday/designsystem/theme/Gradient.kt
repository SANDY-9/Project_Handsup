package com.tenday.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val LinearGradientOrange = Brush.linearGradient(
    colors = listOf(
        Color(0xFFEBA000),
        Color(0xFFFA610F)
    ),
)

val LinearGradientBlue = Brush.linearGradient(
    colors = listOf(
        Color(0xFF9E66E1),
        Color(0xFF1846AA),
    )
)

val LinearGradientSunRise = Brush.linearGradient(
    colors = listOf(
        Color(0xFF0C64E8),
        Color(0xFFFA610F),
    )
)

val LinearGradientNavy = Brush.linearGradient(
    colors = listOf(
        Color(0xFF445368),
        Color(0xFF242B35),
    )
)

val SingleGradientGray = Brush.horizontalGradient(
    colors = listOf(Gray500)
)

val SingleGradientBlue = Brush.horizontalGradient(
    colors = listOf(HandsUpBlue)
)

val SingleGradientNavy = Brush.horizontalGradient(
    colors = listOf(HandsUpNavy)
)