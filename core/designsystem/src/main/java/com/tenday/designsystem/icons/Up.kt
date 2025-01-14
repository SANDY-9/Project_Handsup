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
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

public val Icons.Up: ImageVector
    get() {
        if (_up != null) {
            return _up!!
        }
        _up = Builder(name = "Up", defaultWidth = 21.0.dp, defaultHeight = 20.0.dp, viewportWidth =
                21.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF83DD77)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.333f, 6.0f)
                lineTo(15.333f, 14.0f)
                horizontalLineTo(5.333f)
                lineTo(10.333f, 6.0f)
                close()
            }
        }
        .build()
        return _up!!
    }

private var _up: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Up, contentDescription = "")
    }
}
