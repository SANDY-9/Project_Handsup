package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

val Icons.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info = Builder(name = "Info", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    fillAlpha = 0.5f, strokeAlpha = 0.5f, strokeLineWidth = 1.0f, strokeLineCap =
                    Butt, strokeLineJoin = Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.0f, 14.0f)
                curveTo(11.314f, 14.0f, 14.0f, 11.314f, 14.0f, 8.0f)
                curveTo(14.0f, 4.686f, 11.314f, 2.0f, 8.0f, 2.0f)
                curveTo(4.686f, 2.0f, 2.0f, 4.686f, 2.0f, 8.0f)
                curveTo(2.0f, 11.314f, 4.686f, 14.0f, 8.0f, 14.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(7.346f, 9.36f)
                curveTo(7.333f, 9.034f, 7.386f, 8.714f, 7.499f, 8.407f)
                curveTo(7.646f, 8.107f, 7.853f, 7.847f, 8.106f, 7.627f)
                curveTo(8.313f, 7.447f, 8.506f, 7.247f, 8.679f, 7.027f)
                curveTo(8.799f, 6.854f, 8.866f, 6.647f, 8.866f, 6.434f)
                curveTo(8.879f, 6.2f, 8.806f, 5.967f, 8.653f, 5.794f)
                curveTo(8.479f, 5.634f, 8.253f, 5.554f, 8.019f, 5.574f)
                curveTo(7.786f, 5.56f, 7.553f, 5.64f, 7.373f, 5.794f)
                curveTo(7.206f, 5.947f, 7.119f, 6.16f, 7.126f, 6.38f)
                horizontalLineTo(5.993f)
                curveTo(5.979f, 5.894f, 6.186f, 5.434f, 6.553f, 5.12f)
                curveTo(6.966f, 4.8f, 7.486f, 4.634f, 8.013f, 4.66f)
                curveTo(8.539f, 4.627f, 9.059f, 4.794f, 9.473f, 5.12f)
                curveTo(9.833f, 5.447f, 10.019f, 5.914f, 9.993f, 6.394f)
                curveTo(9.959f, 6.947f, 9.706f, 7.467f, 9.286f, 7.834f)
                lineTo(8.713f, 8.374f)
                curveTo(8.493f, 8.654f, 8.379f, 9.0f, 8.399f, 9.354f)
                horizontalLineTo(7.339f)
                lineTo(7.346f, 9.36f)
                close()
                moveTo(7.266f, 10.754f)
                curveTo(7.266f, 10.594f, 7.319f, 10.434f, 7.439f, 10.327f)
                curveTo(7.566f, 10.214f, 7.733f, 10.154f, 7.906f, 10.16f)
                curveTo(8.079f, 10.154f, 8.246f, 10.214f, 8.373f, 10.327f)
                curveTo(8.486f, 10.44f, 8.546f, 10.594f, 8.546f, 10.747f)
                curveTo(8.546f, 10.9f, 8.486f, 11.054f, 8.379f, 11.16f)
                curveTo(8.253f, 11.28f, 8.079f, 11.34f, 7.906f, 11.327f)
                curveTo(7.733f, 11.34f, 7.559f, 11.28f, 7.433f, 11.16f)
                curveTo(7.326f, 11.054f, 7.266f, 10.9f, 7.266f, 10.747f)
                verticalLineTo(10.754f)
                close()
            }
        }
        .build()
        return _info!!
    }

private var _info: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Info, contentDescription = "")
    }
}
