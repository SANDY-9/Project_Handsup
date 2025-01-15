package com.tenday.designsystem.components

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

public val Icons.Switchon: ImageVector
    get() {
        if (_switchon != null) {
            return _switchon!!
        }
        _switchon = Builder(name = "Switchon", defaultWidth = 52.0.dp, defaultHeight = 28.0.dp,
                viewportWidth = 52.0f, viewportHeight = 28.0f).apply {
            path(fill = SolidColor(Color(0xFFFA610F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.0f, 0.0f)
                lineTo(38.0f, 0.0f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 52.0f, 14.0f)
                lineTo(52.0f, 14.0f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 38.0f, 28.0f)
                lineTo(14.0f, 28.0f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 0.0f, 14.0f)
                lineTo(0.0f, 14.0f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 14.0f, 0.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(38.0f, 2.0f)
                lineTo(38.0f, 2.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 50.0f, 14.0f)
                lineTo(50.0f, 14.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 38.0f, 26.0f)
                lineTo(38.0f, 26.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 26.0f, 14.0f)
                lineTo(26.0f, 14.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 38.0f, 2.0f)
                close()
            }
        }
        .build()
        return _switchon!!
    }

private var _switchon: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Switchon, contentDescription = "")
    }
}
