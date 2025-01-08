package com.tenday.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tenday.designsystem.R

private val suit = FontFamily(
    Font(resId = R.font.suit_regular, weight = FontWeight.Normal),
    Font(resId = R.font.suit_medium, weight = FontWeight.Medium),
    Font(resId = R.font.suit_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.suit_bold, weight = FontWeight.Bold),
    Font(resId = R.font.suit_extrabold, weight = FontWeight.ExtraBold),
)

val HandsUpTypography = Typography(
    title1 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = (33.6).sp,
        letterSpacing = (-0.5).sp,
    ),
    title2 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = (30.8).sp,
        letterSpacing = (-0.5).sp,
    ),
    title3 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.5).sp,
    ),
    title4 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = (25.2).sp,
        letterSpacing = (-0.5).sp,
    ),
    title5 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (22.4).sp,
        letterSpacing = (-0.5).sp,
    ),
    body1 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = (22.4).sp,
        letterSpacing = (-0.5).sp,
    ),
    body2 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (19.6).sp,
        letterSpacing = (-0.5).sp,
    ),
    body3 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = (18.2).sp,
        letterSpacing = (-0.5).sp,
    ),
    body4 = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = (16.8).sp,
        letterSpacing = (-0.5).sp,
    )
)

@Immutable
data class Typography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val title5: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
)