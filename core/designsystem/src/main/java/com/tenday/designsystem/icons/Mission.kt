package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

val Icons.Mission: ImageVector
    get() {
        if (_mission != null) {
            return _mission!!
        }
        _mission = Builder(name = "Mission", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(12.759f, 3.59f)
                curveTo(13.408f, 4.065f, 13.943f, 4.711f, 14.483f, 5.631f)
                lineTo(13.19f, 6.391f)
                curveTo(12.713f, 5.578f, 12.303f, 5.115f, 11.874f, 4.802f)
                curveTo(11.442f, 4.486f, 10.936f, 4.283f, 10.188f, 4.07f)
                lineTo(10.599f, 2.627f)
                curveTo(11.405f, 2.857f, 12.112f, 3.119f, 12.759f, 3.59f)
                close()
                moveTo(10.419f, 5.879f)
                lineTo(10.922f, 6.377f)
                lineTo(15.127f, 10.542f)
                lineTo(15.21f, 9.961f)
                curveTo(15.385f, 8.724f, 16.371f, 7.761f, 17.611f, 7.615f)
                lineTo(18.322f, 7.532f)
                lineTo(18.957f, 7.457f)
                lineTo(19.131f, 8.072f)
                lineTo(20.506f, 12.926f)
                lineTo(20.768f, 13.753f)
                curveTo(21.527f, 16.144f, 20.787f, 18.757f, 18.889f, 20.396f)
                curveTo(16.39f, 22.553f, 12.647f, 22.404f, 10.328f, 20.055f)
                lineTo(4.566f, 14.217f)
                lineTo(4.088f, 13.733f)
                lineTo(4.525f, 13.21f)
                lineTo(5.903f, 11.559f)
                lineTo(4.957f, 10.526f)
                lineTo(4.491f, 10.017f)
                lineTo(4.96f, 9.51f)
                lineTo(6.858f, 7.459f)
                lineTo(7.392f, 6.882f)
                lineTo(7.943f, 7.442f)
                lineTo(8.289f, 7.794f)
                lineTo(9.892f, 6.352f)
                lineTo(10.419f, 5.879f)
                close()
                moveTo(7.425f, 9.054f)
                lineTo(7.723f, 9.357f)
                lineTo(12.151f, 13.853f)
                lineTo(13.22f, 12.8f)
                lineTo(9.343f, 8.864f)
                lineTo(10.369f, 7.941f)
                lineTo(15.133f, 12.658f)
                lineTo(16.403f, 12.23f)
                lineTo(16.695f, 10.171f)
                curveTo(16.774f, 9.609f, 17.222f, 9.171f, 17.786f, 9.105f)
                lineTo(17.862f, 9.096f)
                lineTo(19.065f, 13.346f)
                lineTo(19.069f, 13.358f)
                lineTo(19.072f, 13.369f)
                lineTo(19.338f, 14.207f)
                curveTo(19.915f, 16.026f, 19.353f, 18.014f, 17.908f, 19.261f)
                curveTo(16.007f, 20.902f, 13.16f, 20.788f, 11.396f, 19.001f)
                lineTo(6.112f, 13.649f)
                lineTo(6.932f, 12.666f)
                lineTo(10.024f, 15.949f)
                lineTo(11.116f, 14.921f)
                lineTo(7.448f, 11.026f)
                lineTo(6.53f, 10.022f)
                lineTo(7.425f, 9.054f)
                close()
                moveTo(3.894f, 18.616f)
                curveTo(3.18f, 18.015f, 2.608f, 17.219f, 2.046f, 16.09f)
                lineTo(3.389f, 15.422f)
                curveTo(3.895f, 16.44f, 4.355f, 17.043f, 4.86f, 17.468f)
                curveTo(5.369f, 17.896f, 5.973f, 18.187f, 6.851f, 18.504f)
                lineTo(6.341f, 19.915f)
                curveTo(5.407f, 19.577f, 4.605f, 19.214f, 3.894f, 18.616f)
                close()
            }
        }
        .build()
        return _mission!!
    }

private var _mission: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Mission, contentDescription = "")
    }
}
