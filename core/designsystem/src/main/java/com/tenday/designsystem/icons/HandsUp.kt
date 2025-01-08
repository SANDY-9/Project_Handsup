package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

val Icons.HandsUp: ImageVector
    get() {
        if (_handsup != null) {
            return _handsup!!
        }
        _handsup = Builder(name = "Handsup", defaultWidth = 80.0.dp, defaultHeight = 80.0.dp,
                viewportWidth = 80.0f, viewportHeight = 80.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(-80.0f)
                close()
            }
            path(fill = linearGradient(0.0f to Color(0xFFEE6D3D), 1.0f to Color(0xFFEE603D), start =
                    Offset(40.0f,0.0f), end = Offset(40.0f,80.0f)), stroke = null, strokeLineWidth =
                    0.0f, strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(-80.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(51.392f, 24.0f)
                curveTo(47.357f, 24.0f, 43.733f, 25.815f, 41.238f, 28.693f)
                verticalLineTo(24.091f)
                horizontalLineTo(35.031f)
                verticalLineTo(38.569f)
                horizontalLineTo(35.024f)
                curveTo(34.855f, 42.522f, 31.79f, 45.689f, 27.965f, 45.871f)
                curveTo(27.965f, 45.871f, 27.961f, 45.871f, 27.957f, 45.871f)
                curveTo(27.847f, 45.875f, 27.737f, 45.886f, 27.623f, 45.886f)
                curveTo(27.112f, 45.886f, 26.616f, 45.833f, 26.135f, 45.73f)
                horizontalLineTo(26.127f)
                curveTo(25.888f, 45.681f, 25.657f, 45.617f, 25.429f, 45.544f)
                curveTo(25.414f, 45.541f, 25.399f, 45.533f, 25.389f, 45.529f)
                curveTo(25.172f, 45.457f, 24.962f, 45.381f, 24.753f, 45.29f)
                curveTo(24.727f, 45.279f, 24.705f, 45.267f, 24.679f, 45.256f)
                curveTo(24.484f, 45.168f, 24.293f, 45.077f, 24.11f, 44.971f)
                curveTo(24.076f, 44.952f, 24.043f, 44.929f, 24.007f, 44.91f)
                curveTo(23.834f, 44.812f, 23.665f, 44.709f, 23.503f, 44.595f)
                curveTo(23.459f, 44.565f, 23.419f, 44.531f, 23.375f, 44.5f)
                curveTo(23.228f, 44.394f, 23.081f, 44.284f, 22.937f, 44.162f)
                curveTo(22.886f, 44.12f, 22.838f, 44.071f, 22.79f, 44.029f)
                curveTo(22.665f, 43.915f, 22.54f, 43.801f, 22.419f, 43.684f)
                curveTo(22.364f, 43.627f, 22.309f, 43.566f, 22.254f, 43.505f)
                curveTo(22.147f, 43.391f, 22.044f, 43.278f, 21.945f, 43.156f)
                curveTo(21.886f, 43.084f, 21.831f, 43.008f, 21.772f, 42.932f)
                curveTo(21.688f, 42.818f, 21.6f, 42.704f, 21.522f, 42.586f)
                curveTo(21.464f, 42.499f, 21.409f, 42.408f, 21.353f, 42.317f)
                curveTo(21.284f, 42.203f, 21.218f, 42.093f, 21.155f, 41.975f)
                curveTo(21.1f, 41.873f, 21.048f, 41.766f, 20.997f, 41.664f)
                curveTo(20.942f, 41.554f, 20.89f, 41.444f, 20.839f, 41.33f)
                curveTo(20.791f, 41.216f, 20.747f, 41.098f, 20.703f, 40.98f)
                curveTo(20.663f, 40.87f, 20.622f, 40.76f, 20.585f, 40.646f)
                curveTo(20.545f, 40.521f, 20.512f, 40.396f, 20.475f, 40.266f)
                curveTo(20.446f, 40.156f, 20.416f, 40.046f, 20.391f, 39.932f)
                curveTo(20.361f, 39.799f, 20.339f, 39.667f, 20.317f, 39.534f)
                curveTo(20.299f, 39.42f, 20.28f, 39.306f, 20.266f, 39.192f)
                curveTo(20.251f, 39.055f, 20.236f, 38.918f, 20.229f, 38.782f)
                curveTo(20.218f, 38.6f, 20.203f, 38.421f, 20.203f, 38.235f)
                curveTo(20.203f, 34.001f, 23.525f, 30.569f, 27.623f, 30.569f)
                curveTo(27.737f, 30.569f, 27.847f, 30.58f, 27.957f, 30.588f)
                verticalLineTo(24.156f)
                curveTo(27.847f, 24.156f, 27.737f, 24.148f, 27.623f, 24.148f)
                curveTo(20.097f, 24.148f, 14.0f, 30.451f, 14.0f, 38.224f)
                curveTo(14.0f, 38.338f, 14.007f, 38.455f, 14.007f, 38.569f)
                horizontalLineTo(14.0f)
                curveTo(14.0f, 38.691f, 14.011f, 38.812f, 14.018f, 38.938f)
                curveTo(14.018f, 38.945f, 14.018f, 38.953f, 14.018f, 38.96f)
                curveTo(14.029f, 39.192f, 14.048f, 39.424f, 14.07f, 39.655f)
                curveTo(14.07f, 39.663f, 14.07f, 39.67f, 14.07f, 39.674f)
                curveTo(14.092f, 39.906f, 14.121f, 40.134f, 14.154f, 40.361f)
                curveTo(14.154f, 40.365f, 14.154f, 40.373f, 14.154f, 40.377f)
                curveTo(14.187f, 40.604f, 14.228f, 40.832f, 14.272f, 41.056f)
                curveTo(14.272f, 41.056f, 14.272f, 41.064f, 14.272f, 41.068f)
                curveTo(14.316f, 41.296f, 14.368f, 41.52f, 14.423f, 41.743f)
                curveTo(15.937f, 47.815f, 21.262f, 52.303f, 27.608f, 52.303f)
                curveTo(27.608f, 52.303f, 27.608f, 52.303f, 27.612f, 52.303f)
                curveTo(27.615f, 52.303f, 27.612f, 52.303f, 27.615f, 52.303f)
                curveTo(27.726f, 52.303f, 27.84f, 52.296f, 27.95f, 52.296f)
                curveTo(30.555f, 52.227f, 32.973f, 51.403f, 35.017f, 50.032f)
                verticalLineTo(57.0f)
                horizontalLineTo(41.223f)
                verticalLineTo(47.462f)
                curveTo(43.719f, 50.34f, 47.342f, 52.155f, 51.377f, 52.155f)
                curveTo(58.903f, 52.155f, 65.0f, 45.852f, 65.0f, 38.079f)
                curveTo(65.0f, 30.307f, 58.918f, 24.0f, 51.392f, 24.0f)
                close()
                moveTo(51.392f, 45.518f)
                curveTo(47.294f, 45.518f, 43.972f, 42.085f, 43.972f, 37.852f)
                curveTo(43.972f, 33.618f, 47.294f, 30.185f, 51.392f, 30.185f)
                curveTo(55.489f, 30.185f, 58.812f, 33.618f, 58.812f, 37.852f)
                curveTo(58.812f, 42.085f, 55.489f, 45.518f, 51.392f, 45.518f)
                close()
            }
        }
        .build()
        return _handsup!!
    }

private var _handsup: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.HandsUp, contentDescription = "")
    }
}
