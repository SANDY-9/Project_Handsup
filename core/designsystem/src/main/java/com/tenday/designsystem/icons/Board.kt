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

val Icons.Board: ImageVector
    get() {
        if (_board != null) {
            return _board!!
        }
        _board = Builder(name = "Board", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.662f, 16.429f)
                lineTo(18.038f, 16.013f)
                curveTo(17.904f, 16.214f, 17.875f, 16.466f, 17.96f, 16.692f)
                lineTo(18.662f, 16.429f)
                close()
                moveTo(16.431f, 18.66f)
                lineTo(16.695f, 17.958f)
                curveTo(16.469f, 17.874f, 16.216f, 17.903f, 16.015f, 18.037f)
                lineTo(16.431f, 18.66f)
                close()
                moveTo(20.001f, 19.999f)
                lineTo(19.738f, 20.701f)
                curveTo(20.013f, 20.805f, 20.323f, 20.737f, 20.531f, 20.529f)
                curveTo(20.739f, 20.322f, 20.807f, 20.011f, 20.703f, 19.736f)
                lineTo(20.001f, 19.999f)
                close()
                moveTo(19.249f, 12.0f)
                curveTo(19.249f, 13.485f, 18.803f, 14.864f, 18.038f, 16.013f)
                lineTo(19.286f, 16.845f)
                curveTo(20.211f, 15.457f, 20.749f, 13.79f, 20.749f, 12.0f)
                horizontalLineTo(19.249f)
                close()
                moveTo(12.0f, 4.75f)
                curveTo(16.003f, 4.75f, 19.249f, 7.996f, 19.249f, 12.0f)
                horizontalLineTo(20.749f)
                curveTo(20.749f, 7.167f, 16.832f, 3.25f, 12.0f, 3.25f)
                verticalLineTo(4.75f)
                close()
                moveTo(4.75f, 12.0f)
                curveTo(4.75f, 7.996f, 7.996f, 4.75f, 12.0f, 4.75f)
                verticalLineTo(3.25f)
                curveTo(7.167f, 3.25f, 3.25f, 7.167f, 3.25f, 12.0f)
                horizontalLineTo(4.75f)
                close()
                moveTo(12.0f, 19.249f)
                curveTo(7.996f, 19.249f, 4.75f, 16.003f, 4.75f, 12.0f)
                horizontalLineTo(3.25f)
                curveTo(3.25f, 16.832f, 7.167f, 20.749f, 12.0f, 20.749f)
                verticalLineTo(19.249f)
                close()
                moveTo(16.015f, 18.037f)
                curveTo(14.866f, 18.803f, 13.486f, 19.249f, 12.0f, 19.249f)
                verticalLineTo(20.749f)
                curveTo(13.791f, 20.749f, 15.459f, 20.21f, 16.847f, 19.285f)
                lineTo(16.015f, 18.037f)
                close()
                moveTo(16.168f, 19.363f)
                lineTo(19.738f, 20.701f)
                lineTo(20.264f, 19.297f)
                lineTo(16.695f, 17.958f)
                lineTo(16.168f, 19.363f)
                close()
                moveTo(20.703f, 19.736f)
                lineTo(19.364f, 16.166f)
                lineTo(17.96f, 16.692f)
                lineTo(19.299f, 20.262f)
                lineTo(20.703f, 19.736f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.0f, 12.0f)
                moveToRelative(-1.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0f, 12.0f)
                moveToRelative(-1.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 12.0f)
                moveToRelative(-1.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f)
            }
        }
        .build()
        return _board!!
    }

private var _board: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Board, contentDescription = "")
    }
}
