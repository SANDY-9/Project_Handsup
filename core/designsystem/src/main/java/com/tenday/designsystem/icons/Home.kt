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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val Icons.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFFA610F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(2.187f, 9.867f)
                    lineTo(3.126f, 11.038f)
                    horizontalLineTo(3.126f)
                    lineTo(2.187f, 9.867f)
                    close()
                    moveTo(10.5f, 22.0f)
                    verticalLineTo(23.5f)
                    horizontalLineTo(12.0f)
                    verticalLineTo(22.0f)
                    horizontalLineTo(10.5f)
                    close()
                    moveTo(10.5f, 18.0f)
                    verticalLineTo(16.5f)
                    horizontalLineTo(9.0f)
                    verticalLineTo(18.0f)
                    horizontalLineTo(10.5f)
                    close()
                    moveTo(13.5f, 18.0f)
                    horizontalLineTo(15.0f)
                    verticalLineTo(16.5f)
                    horizontalLineTo(13.5f)
                    verticalLineTo(18.0f)
                    close()
                    moveTo(13.5f, 22.0f)
                    horizontalLineTo(12.0f)
                    verticalLineTo(23.5f)
                    horizontalLineTo(13.5f)
                    verticalLineTo(22.0f)
                    close()
                    moveTo(21.813f, 9.867f)
                    lineTo(22.751f, 8.697f)
                    lineTo(22.751f, 8.697f)
                    lineTo(21.813f, 9.867f)
                    close()
                    moveTo(12.313f, 2.251f)
                    lineTo(13.251f, 1.08f)
                    lineTo(13.251f, 1.08f)
                    lineTo(12.313f, 2.251f)
                    close()
                    moveTo(11.687f, 2.251f)
                    lineTo(10.749f, 1.08f)
                    lineTo(10.749f, 1.08f)
                    lineTo(11.687f, 2.251f)
                    close()
                    moveTo(3.5f, 10.257f)
                    curveTo(3.5f, 10.561f, 3.362f, 10.848f, 3.126f, 11.038f)
                    lineTo(1.249f, 8.697f)
                    curveTo(0.776f, 9.076f, 0.5f, 9.65f, 0.5f, 10.257f)
                    horizontalLineTo(3.5f)
                    close()
                    moveTo(3.5f, 21.5f)
                    verticalLineTo(10.257f)
                    horizontalLineTo(0.5f)
                    verticalLineTo(21.5f)
                    horizontalLineTo(3.5f)
                    close()
                    moveTo(2.5f, 20.5f)
                    curveTo(3.052f, 20.5f, 3.5f, 20.948f, 3.5f, 21.5f)
                    horizontalLineTo(0.5f)
                    curveTo(0.5f, 22.605f, 1.395f, 23.5f, 2.5f, 23.5f)
                    verticalLineTo(20.5f)
                    close()
                    moveTo(10.5f, 20.5f)
                    horizontalLineTo(2.5f)
                    verticalLineTo(23.5f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(20.5f)
                    close()
                    moveTo(12.0f, 22.0f)
                    verticalLineTo(18.0f)
                    horizontalLineTo(9.0f)
                    verticalLineTo(22.0f)
                    horizontalLineTo(12.0f)
                    close()
                    moveTo(10.5f, 19.5f)
                    horizontalLineTo(13.5f)
                    verticalLineTo(16.5f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(19.5f)
                    close()
                    moveTo(12.0f, 18.0f)
                    verticalLineTo(22.0f)
                    horizontalLineTo(15.0f)
                    verticalLineTo(18.0f)
                    horizontalLineTo(12.0f)
                    close()
                    moveTo(21.5f, 20.5f)
                    horizontalLineTo(13.5f)
                    verticalLineTo(23.5f)
                    horizontalLineTo(21.5f)
                    verticalLineTo(20.5f)
                    close()
                    moveTo(20.5f, 21.5f)
                    curveTo(20.5f, 20.948f, 20.948f, 20.5f, 21.5f, 20.5f)
                    verticalLineTo(23.5f)
                    curveTo(22.605f, 23.5f, 23.5f, 22.605f, 23.5f, 21.5f)
                    horizontalLineTo(20.5f)
                    close()
                    moveTo(20.5f, 10.257f)
                    verticalLineTo(21.5f)
                    horizontalLineTo(23.5f)
                    verticalLineTo(10.257f)
                    horizontalLineTo(20.5f)
                    close()
                    moveTo(20.875f, 11.038f)
                    curveTo(20.638f, 10.848f, 20.5f, 10.561f, 20.5f, 10.257f)
                    horizontalLineTo(23.5f)
                    curveTo(23.5f, 9.65f, 23.225f, 9.076f, 22.751f, 8.697f)
                    lineTo(20.875f, 11.038f)
                    close()
                    moveTo(11.375f, 3.421f)
                    lineTo(20.875f, 11.038f)
                    lineTo(22.751f, 8.697f)
                    lineTo(13.251f, 1.08f)
                    lineTo(11.375f, 3.421f)
                    close()
                    moveTo(12.625f, 3.421f)
                    curveTo(12.26f, 3.714f, 11.74f, 3.714f, 11.375f, 3.421f)
                    lineTo(13.251f, 1.08f)
                    curveTo(12.52f, 0.494f, 11.48f, 0.494f, 10.749f, 1.08f)
                    lineTo(12.625f, 3.421f)
                    close()
                    moveTo(3.126f, 11.038f)
                    lineTo(12.625f, 3.421f)
                    lineTo(10.749f, 1.08f)
                    lineTo(1.249f, 8.697f)
                    lineTo(3.126f, 11.038f)
                    close()
                }
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Home, contentDescription = "")
    }
}
