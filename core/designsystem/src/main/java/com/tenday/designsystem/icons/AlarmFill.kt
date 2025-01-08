package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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

val Icons.AlarmFill: ImageVector
    get() {
        if (_alarmFill != null) {
            return _alarmFill!!
        }
        _alarmFill = Builder(name = "AlarmFill", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(18.811f, 8.618f)
                curveTo(18.811f, 4.933f, 15.762f, 1.946f, 12.0f, 1.946f)
                curveTo(8.239f, 1.946f, 5.189f, 4.933f, 5.189f, 8.618f)
                verticalLineTo(13.998f)
                curveTo(5.189f, 14.205f, 5.125f, 14.408f, 5.005f, 14.577f)
                lineTo(4.04f, 15.935f)
                curveTo(3.57f, 16.597f, 4.043f, 17.514f, 4.856f, 17.514f)
                horizontalLineTo(19.145f)
                curveTo(19.957f, 17.514f, 20.43f, 16.597f, 19.96f, 15.935f)
                lineTo(18.996f, 14.577f)
                curveTo(18.875f, 14.408f, 18.811f, 14.205f, 18.811f, 13.998f)
                verticalLineTo(8.618f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 0.648649f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.432f, 20.433f)
                horizontalLineToRelative(7.135f)
                verticalLineToRelative(0.649f)
                horizontalLineToRelative(-7.135f)
                close()
            }
        }
        .build()
        return _alarmFill!!
    }

private var _alarmFill: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.AlarmFill, contentDescription = "")
    }
}
