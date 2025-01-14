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

val LinearGradientGreen = Brush.linearGradient(
    colors = listOf(
        Color(0xFF399500),
        Color(0xFF06798D),
    )
)

val LinearGradientPurple = Brush.linearGradient(
    colors = listOf(
        Color(0xFFC03BEC),
        Color(0xFF7200B5),
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
    colors = listOf(
        Gray500,
        Gray500
    )
)

val SingleGradientBlue = Brush.horizontalGradient(
    colors = listOf(
        HandsUpBlue,
        HandsUpBlue
    )
)

val SingleGradientNavy = Brush.horizontalGradient(
    colors = listOf(
        HandsUpNavy,
        HandsUpNavy
    )
)

private val HandsUpGradientGroup = listOf(
    LinearGradientOrange,
    LinearGradientBlue,
    LinearGradientGreen,
    LinearGradientPurple,
    LinearGradientNavy,
)
fun getHandsUpGradient(index: Int): Brush {
    val gradientNumber = index % HandsUpGradientGroup.size
    return HandsUpGradientGroup[gradientNumber]
}