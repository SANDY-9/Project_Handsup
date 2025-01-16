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

public val Icons.Remain: ImageVector
    get() {
        if (_remain != null) {
            return _remain!!
        }
        _remain = Builder(name = "Remain", defaultWidth = 11.0.dp, defaultHeight = 4.0.dp,
                viewportWidth = 11.0f, viewportHeight = 4.0f).apply {
            path(fill = SolidColor(Color(0xFFFFC31E)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.333f, 0.0f)
                horizontalLineToRelative(10.0f)
                verticalLineToRelative(4.0f)
                horizontalLineToRelative(-10.0f)
                close()
            }
        }
        .build()
        return _remain!!
    }

private var _remain: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Remain, contentDescription = "")
    }
}
