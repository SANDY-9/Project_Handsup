package com.tenday.designsystem.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenday.designsystem.theme.GradientShadow
import com.tenday.designsystem.theme.Gray200

val gradientBrush = Brush.horizontalGradient(
    colors = listOf(Color(0xFFFA610F), Color(0xFFFFC31E)),
    startX = 10f,
    endX = 500f,
)

val shadowGradient = listOf(
    GradientShadow,
    Color.Transparent,
)
@Composable
fun LevelGraph(
    currentValue: Int,
    maxValue: Int = 27500,
    modifier: Modifier = Modifier,
) {
    val progress = currentValue.toFloat() / maxValue
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Draw background bar
            drawRoundRect(
                color = Gray200,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(50f, 50f)
            )

            // Draw progress bar
            drawRoundRect(
                brush = gradientBrush,
                size = Size(size.width * progress, size.height),
                cornerRadius = CornerRadius(50f, 50f)
            )

            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = shadowGradient,
                    startY = 0f,
                    endY = size.height * 0.4f
                ),
                cornerRadius = CornerRadius(50f, 50f),
            )
        }

        // Draw percentage text
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            BasicText(
                text = "${(progress * 100).toInt()}%",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview(name = "LevelGraph")
@Composable
private fun PreviewLevelGraph() {
    LevelGraph(27300)
}