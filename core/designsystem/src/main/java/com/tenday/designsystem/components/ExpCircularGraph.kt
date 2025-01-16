package com.tenday.designsystem.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.extentions.innerShadow
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import kotlin.math.roundToInt

private val pieChartGradientBrush = Brush.linearGradient(
    colors = listOf(Color(0xFFFA610F), Color(0xFFFBBE1D)),
)

@Composable
fun ExpCircularGraph(
    currentYearExp: Int,
    avg: Int = 9000,
    modifier: Modifier = Modifier
) {
    var currentExp  by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        currentExp  = currentYearExp // 예시: 목표 값으로 설정
    }
    val animatedProgress by animateFloatAsState(
        targetValue = currentExp.toFloat() / avg.toFloat(),
        animationSpec = tween(
            durationMillis = 5000,
            easing = LinearOutSlowInEasing
        )
    )
    val percent = remember { (animatedProgress * 100).roundToInt() }
    Box(
        modifier = modifier.size(140.dp), // 전체 원의 크기 (반경 = 70dp 기준)
        contentAlignment = Alignment.Center
    ) {
        // 바깥쪽 반원
        Canvas(
            modifier = modifier.fillMaxSize()
                .innerShadow(
                    shape = CircleShape,
                    offsetY = 4.dp,
                    offsetX = 0.dp,
                )
        ) {
            drawArc(
                color = Gray100, // 배경색
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
            )

            // progress
            drawArc(
                brush = pieChartGradientBrush, // 진행 색상
                startAngle = 270f,
                sweepAngle = animatedProgress * 360f, // 진행 정도
                useCenter = true,
            )
        }

        // 안쪽 원
        Canvas(
            modifier = modifier
                .size(91.dp)
                .blurShadow(
                    borderRadius = 50.dp,
                    blurRadius = 4.dp,
                    offsetY = 4.dp,
                )
        ) { // 반경 45.5dp
            drawCircle(
                color = Color.White, // 안쪽 원의 배경색
                radius = size.minDimension / 2
            )
        }

        // 중앙 텍스트
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${percent}%",
                style = HandsUpTypography.title3,
                color = HandsUpOrange,
            )
            Text(
                text = "평균 $avg 기준",
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp,
                    color = Gray700
                ),
            )
        }
    }
}

@Preview(name = "ExpCircularGraph")
@Composable
private fun PreviewExpCircularGraph() {
    ExpCircularGraph(5730)
}