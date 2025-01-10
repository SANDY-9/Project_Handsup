package com.tenday.designsystem.extentions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dashedFill(
    color: Color,
    strokeWidth: Dp = 3.dp,
    gapLength: Dp = 3.dp,
) = this.drawWithContent {
    drawContent() // 기존 콘텐츠를 그립니다.

    val strokeWidthPx = strokeWidth.toPx()
    val stripeInterval = gapLength.toPx() + strokeWidthPx

    var x = 0f
    while (x < size.width) {
        drawRect(
            color = color,
            topLeft = Offset(x, 0f),
            size = Size(strokeWidthPx, size.height)
        )
        x += stripeInterval
    }
}