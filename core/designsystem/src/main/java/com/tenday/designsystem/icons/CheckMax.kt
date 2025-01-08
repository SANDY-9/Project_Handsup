package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

val Icons.CheckMax: ImageVector
    get() {
        if (_checkMax != null) {
            return _checkMax!!
        }
        _checkMax = Builder(name = "CheckMax", defaultWidth = 120.0.dp, defaultHeight = 120.0.dp,
                viewportWidth = 120.0f, viewportHeight = 120.0f).apply {
            path(fill = SolidColor(Color(0xFFEE663D)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.5f, 0.0f)
                arcToRelative(59.5f, 59.5f, 0.0f, true, true, 119.0f, 0.0f)
                arcToRelative(59.5f, 59.5f, 0.0f, true, true, -119.0f, 0.0f)
            }
            path(fill = radialGradient(0.0f to Color(0xFFFF5900), 0.5f to Color(0xFFFA610F), 1.0f to
                    Color(0xFFFF7327), center = Offset(60.0f,60.0f), radius = 60.0f), stroke =
                    SolidColor(Color(0xFFffffff)), strokeLineWidth = 1.5f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.25f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, 118.5f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, -118.5f, 0.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 12.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(34.0f, 57.86f)
                lineTo(53.36f, 79.0f)
                lineTo(87.0f, 41.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-51.25f, 0.0f)
                arcToRelative(51.25f, 51.25f, 0.0f, true, true, 102.5f, 0.0f)
                arcToRelative(51.25f, 51.25f, 0.0f, true, true, -102.5f, 0.0f)
            }
        }
        .build()
        return _checkMax!!
    }

private var _checkMax: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.CheckMax, contentDescription = "")
    }
}
