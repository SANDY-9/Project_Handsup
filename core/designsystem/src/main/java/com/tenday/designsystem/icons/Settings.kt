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

val Icons.Settings: ImageVector
    get() {
        if (_settings != null) {
            return _settings!!
        }
        _settings = Builder(name = "Settings", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(9.608f, 2.066f)
                curveTo(10.377f, 1.892f, 11.178f, 1.8f, 12.0f, 1.8f)
                curveTo(12.821f, 1.8f, 13.623f, 1.892f, 14.392f, 2.066f)
                curveTo(15.288f, 2.269f, 15.725f, 3.042f, 15.896f, 3.586f)
                curveTo(16.028f, 4.009f, 16.321f, 4.391f, 16.762f, 4.638f)
                curveTo(17.175f, 4.869f, 17.64f, 4.936f, 18.079f, 4.859f)
                curveTo(18.645f, 4.759f, 19.5f, 4.806f, 20.079f, 5.483f)
                curveTo(20.816f, 6.343f, 21.41f, 7.324f, 21.826f, 8.392f)
                curveTo(22.21f, 9.378f, 21.642f, 10.255f, 21.17f, 10.694f)
                curveTo(20.808f, 11.03f, 20.592f, 11.493f, 20.592f, 12.0f)
                curveTo(20.592f, 12.507f, 20.808f, 12.97f, 21.17f, 13.306f)
                curveTo(21.642f, 13.745f, 22.21f, 14.622f, 21.826f, 15.608f)
                curveTo(21.41f, 16.676f, 20.816f, 17.657f, 20.08f, 18.516f)
                curveTo(19.501f, 19.193f, 18.645f, 19.241f, 18.08f, 19.141f)
                curveTo(17.64f, 19.063f, 17.175f, 19.131f, 16.762f, 19.361f)
                curveTo(16.321f, 19.608f, 16.028f, 19.991f, 15.896f, 20.413f)
                curveTo(15.725f, 20.958f, 15.288f, 21.731f, 14.392f, 21.934f)
                curveTo(13.622f, 22.108f, 12.821f, 22.2f, 12.0f, 22.2f)
                curveTo(11.178f, 22.2f, 10.377f, 22.108f, 9.608f, 21.934f)
                curveTo(8.711f, 21.731f, 8.275f, 20.958f, 8.104f, 20.414f)
                curveTo(7.971f, 19.991f, 7.678f, 19.608f, 7.237f, 19.362f)
                curveTo(6.825f, 19.131f, 6.359f, 19.064f, 5.92f, 19.141f)
                curveTo(5.355f, 19.241f, 4.499f, 19.194f, 3.92f, 18.517f)
                curveTo(3.184f, 17.657f, 2.589f, 16.676f, 2.173f, 15.608f)
                curveTo(1.789f, 14.622f, 2.357f, 13.745f, 2.83f, 13.306f)
                curveTo(3.191f, 12.97f, 3.408f, 12.507f, 3.408f, 12.0f)
                curveTo(3.408f, 11.493f, 3.191f, 11.03f, 2.83f, 10.694f)
                curveTo(2.357f, 10.255f, 1.789f, 9.378f, 2.173f, 8.391f)
                curveTo(2.589f, 7.324f, 3.184f, 6.343f, 3.92f, 5.483f)
                curveTo(4.499f, 4.806f, 5.355f, 4.759f, 5.92f, 4.859f)
                curveTo(6.359f, 4.936f, 6.825f, 4.869f, 7.237f, 4.638f)
                curveTo(7.678f, 4.392f, 7.971f, 4.009f, 8.104f, 3.586f)
                curveTo(8.274f, 3.042f, 8.711f, 2.269f, 9.608f, 2.066f)
                close()
                moveTo(10.044f, 3.915f)
                curveTo(10.04f, 3.919f, 10.035f, 3.924f, 10.029f, 3.931f)
                curveTo(9.995f, 3.97f, 9.951f, 4.045f, 9.917f, 4.155f)
                curveTo(9.641f, 5.033f, 9.036f, 5.81f, 8.165f, 6.296f)
                curveTo(7.353f, 6.75f, 6.44f, 6.88f, 5.589f, 6.73f)
                curveTo(5.488f, 6.712f, 5.411f, 6.717f, 5.368f, 6.727f)
                curveTo(5.361f, 6.729f, 5.356f, 6.731f, 5.352f, 6.732f)
                curveTo(4.761f, 7.424f, 4.286f, 8.21f, 3.952f, 9.06f)
                curveTo(3.953f, 9.064f, 3.955f, 9.07f, 3.958f, 9.078f)
                curveTo(3.979f, 9.132f, 4.031f, 9.217f, 4.124f, 9.303f)
                curveTo(4.848f, 9.976f, 5.308f, 10.934f, 5.308f, 12.0f)
                curveTo(5.308f, 13.066f, 4.848f, 14.024f, 4.124f, 14.697f)
                curveTo(4.031f, 14.783f, 3.979f, 14.868f, 3.958f, 14.922f)
                curveTo(3.955f, 14.93f, 3.953f, 14.936f, 3.952f, 14.94f)
                curveTo(4.286f, 15.79f, 4.761f, 16.576f, 5.352f, 17.268f)
                curveTo(5.356f, 17.27f, 5.361f, 17.271f, 5.368f, 17.273f)
                curveTo(5.411f, 17.283f, 5.488f, 17.288f, 5.589f, 17.27f)
                curveTo(6.44f, 17.12f, 7.353f, 17.25f, 8.165f, 17.704f)
                curveTo(9.036f, 18.191f, 9.641f, 18.967f, 9.917f, 19.846f)
                curveTo(9.951f, 19.955f, 9.995f, 20.03f, 10.029f, 20.069f)
                curveTo(10.035f, 20.076f, 10.04f, 20.081f, 10.044f, 20.085f)
                curveTo(10.671f, 20.225f, 11.326f, 20.3f, 12.0f, 20.3f)
                curveTo(12.674f, 20.3f, 13.328f, 20.225f, 13.955f, 20.085f)
                curveTo(13.959f, 20.081f, 13.964f, 20.076f, 13.97f, 20.069f)
                curveTo(14.004f, 20.03f, 14.048f, 19.955f, 14.082f, 19.845f)
                curveTo(14.358f, 18.967f, 14.964f, 18.19f, 15.835f, 17.703f)
                curveTo(16.647f, 17.249f, 17.559f, 17.119f, 18.411f, 17.27f)
                curveTo(18.512f, 17.288f, 18.589f, 17.282f, 18.632f, 17.272f)
                curveTo(18.639f, 17.27f, 18.644f, 17.269f, 18.648f, 17.268f)
                curveTo(19.238f, 16.575f, 19.713f, 15.79f, 20.047f, 14.94f)
                curveTo(20.046f, 14.936f, 20.044f, 14.93f, 20.041f, 14.922f)
                curveTo(20.021f, 14.868f, 19.968f, 14.783f, 19.876f, 14.697f)
                curveTo(19.151f, 14.024f, 18.692f, 13.066f, 18.692f, 12.0f)
                curveTo(18.692f, 10.934f, 19.151f, 9.976f, 19.876f, 9.303f)
                curveTo(19.968f, 9.217f, 20.021f, 9.132f, 20.041f, 9.078f)
                curveTo(20.044f, 9.07f, 20.046f, 9.064f, 20.047f, 9.06f)
                curveTo(19.713f, 8.21f, 19.238f, 7.424f, 18.647f, 6.732f)
                curveTo(18.644f, 6.731f, 18.638f, 6.729f, 18.631f, 6.727f)
                curveTo(18.588f, 6.717f, 18.511f, 6.712f, 18.41f, 6.73f)
                curveTo(17.559f, 6.88f, 16.647f, 6.75f, 15.835f, 6.296f)
                curveTo(14.964f, 5.809f, 14.358f, 5.033f, 14.083f, 4.155f)
                curveTo(14.048f, 4.045f, 14.004f, 3.97f, 13.971f, 3.931f)
                curveTo(13.964f, 3.924f, 13.959f, 3.919f, 13.956f, 3.915f)
                curveTo(13.328f, 3.775f, 12.674f, 3.7f, 12.0f, 3.7f)
                curveTo(11.326f, 3.7f, 10.671f, 3.775f, 10.044f, 3.915f)
                close()
                moveTo(20.05f, 9.049f)
                curveTo(20.05f, 9.049f, 20.05f, 9.049f, 20.049f, 9.05f)
                lineTo(20.05f, 9.049f)
                close()
                moveTo(3.95f, 14.951f)
                curveTo(3.95f, 14.951f, 3.95f, 14.951f, 3.95f, 14.95f)
                lineTo(3.95f, 14.951f)
                close()
                moveTo(8.05f, 12.0f)
                curveTo(8.05f, 9.818f, 9.818f, 8.05f, 12.0f, 8.05f)
                curveTo(14.181f, 8.05f, 15.95f, 9.818f, 15.95f, 12.0f)
                curveTo(15.95f, 14.182f, 14.181f, 15.95f, 12.0f, 15.95f)
                curveTo(9.818f, 15.95f, 8.05f, 14.182f, 8.05f, 12.0f)
                close()
                moveTo(12.0f, 9.95f)
                curveTo(10.868f, 9.95f, 9.95f, 10.868f, 9.95f, 12.0f)
                curveTo(9.95f, 13.132f, 10.868f, 14.05f, 12.0f, 14.05f)
                curveTo(13.132f, 14.05f, 14.05f, 13.132f, 14.05f, 12.0f)
                curveTo(14.05f, 10.868f, 13.132f, 9.95f, 12.0f, 9.95f)
                close()
            }
        }
        .build()
        return _settings!!
    }

private var _settings: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Settings, contentDescription = "")
    }
}
