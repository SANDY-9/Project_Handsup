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
import kotlin.Unit

val Icons.Exp: ImageVector
    get() {
        if (_exp != null) {
            return _exp!!
        }
        _exp = Builder(name = "Exp", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp, viewportWidth
                = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFBBBBBB)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 12.0f)
                moveToRelative(-9.25f, 0.0f)
                arcToRelative(9.25f, 9.25f, 0.0f, true, true, 18.5f, 0.0f)
                arcToRelative(9.25f, 9.25f, 0.0f, true, true, -18.5f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 16.0f)
                curveTo(16.0f, 16.552f, 15.552f, 17.0f, 15.0f, 17.0f)
                horizontalLineTo(14.435f)
                curveTo(13.883f, 17.0f, 13.435f, 16.552f, 13.435f, 16.0f)
                verticalLineTo(14.314f)
                curveTo(13.435f, 13.762f, 12.987f, 13.314f, 12.435f, 13.314f)
                horizontalLineTo(11.565f)
                curveTo(11.013f, 13.314f, 10.565f, 13.762f, 10.565f, 14.314f)
                verticalLineTo(16.0f)
                curveTo(10.565f, 16.552f, 10.117f, 17.0f, 9.565f, 17.0f)
                horizontalLineTo(9.0f)
                curveTo(8.448f, 17.0f, 8.0f, 16.552f, 8.0f, 16.0f)
                verticalLineTo(8.0f)
                curveTo(8.0f, 7.448f, 8.448f, 7.0f, 9.0f, 7.0f)
                horizontalLineTo(9.565f)
                curveTo(10.117f, 7.0f, 10.565f, 7.448f, 10.565f, 8.0f)
                verticalLineTo(9.422f)
                curveTo(10.565f, 9.975f, 11.013f, 10.422f, 11.565f, 10.422f)
                horizontalLineTo(12.435f)
                curveTo(12.987f, 10.422f, 13.435f, 9.975f, 13.435f, 9.422f)
                verticalLineTo(8.0f)
                curveTo(13.435f, 7.448f, 13.883f, 7.0f, 14.435f, 7.0f)
                horizontalLineTo(15.0f)
                curveTo(15.552f, 7.0f, 16.0f, 7.448f, 16.0f, 8.0f)
                verticalLineTo(16.0f)
                close()
            }
        }
        .build()
        return _exp!!
    }

private var _exp: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Exp, contentDescription = "")
    }
}
