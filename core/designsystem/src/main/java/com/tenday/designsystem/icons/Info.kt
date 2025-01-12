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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val Icons.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info = Builder(name = "Info", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    fillAlpha = 0.8f, strokeAlpha = 0.8f, strokeLineWidth = 1.0f, strokeLineCap =
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
                moveTo(8.0f, 10.0f)
                curveTo(7.633f, 10.0f, 7.333f, 10.3f, 7.333f, 10.667f)
                curveTo(7.333f, 11.033f, 7.633f, 11.333f, 8.0f, 11.333f)
                curveTo(8.367f, 11.333f, 8.667f, 11.033f, 8.667f, 10.667f)
                curveTo(8.667f, 10.3f, 8.367f, 10.0f, 8.0f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.0f, 5.333f)
                verticalLineTo(8.0f)
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
