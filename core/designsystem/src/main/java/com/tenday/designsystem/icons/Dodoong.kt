package com.tenday.designsystem.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
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

val Icons.Dodoong: ImageVector
    get() {
        if (_dodoong != null) {
            return _dodoong!!
        }
        _dodoong = Builder(name = "Dodoong", defaultWidth = 120.0.dp, defaultHeight = 120.0.dp,
                viewportWidth = 120.0f, viewportHeight = 120.0f).apply {
            path(fill = SolidColor(Color(0xFFEE663D)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.5f, 0.0f)
                arcToRelative(59.5f, 59.5f, 0.0f, true, true, 119.0f, 0.0f)
                arcToRelative(59.5f, 59.5f, 0.0f, true, true, -119.0f, 0.0f)
            }
            path(fill = linearGradient(0.0f to Color(0xFFFF8D80), 1.0f to Color(0xFFFA610F), start =
                    Offset(60.0f,-14.8f), end = Offset(60.0f,139.41f)), stroke = null,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.25f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, 118.5f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, -118.5f, 0.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.25f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, 118.5f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, -118.5f, 0.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeAlpha = 0.24f, strokeLineWidth = 1.5f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-59.25f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, 118.5f, 0.0f)
                arcToRelative(59.25f, 59.25f, 0.0f, true, true, -118.5f, 0.0f)
            }
            path(fill = radialGradient(0.0f to Color(0xFFFFFFFF), 1.0f to Color(0xFFE0E0E0), center
                    = Offset(60.0f,60.0f), radius = 20.0f), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(39.37f, 79.85f)
                curveTo(37.31f, 79.85f, 35.42f, 79.29f, 33.69f, 78.19f)
                curveTo(31.97f, 77.08f, 30.59f, 75.41f, 29.54f, 73.16f)
                curveTo(28.51f, 70.91f, 28.0f, 68.08f, 28.0f, 64.66f)
                curveTo(28.0f, 61.09f, 28.54f, 58.19f, 29.62f, 55.95f)
                curveTo(30.71f, 53.72f, 32.12f, 52.08f, 33.84f, 51.04f)
                curveTo(35.57f, 50.0f, 37.39f, 49.48f, 39.3f, 49.48f)
                curveTo(40.73f, 49.48f, 41.98f, 49.74f, 43.06f, 50.25f)
                curveTo(44.14f, 50.75f, 45.05f, 51.43f, 45.77f, 52.27f)
                curveTo(46.49f, 53.09f, 47.03f, 53.99f, 47.41f, 54.97f)
                curveTo(47.42f, 55.01f, 47.46f, 55.03f, 47.49f, 55.03f)
                curveTo(47.54f, 55.03f, 47.58f, 54.99f, 47.58f, 54.94f)
                verticalLineTo(45.2f)
                curveTo(47.58f, 42.33f, 49.91f, 40.0f, 52.78f, 40.0f)
                curveTo(55.65f, 40.0f, 57.98f, 42.33f, 57.98f, 45.2f)
                verticalLineTo(74.3f)
                curveTo(57.98f, 77.15f, 55.67f, 79.46f, 52.82f, 79.46f)
                horizontalLineTo(50.09f)
                curveTo(48.74f, 79.46f, 47.66f, 78.37f, 47.66f, 77.03f)
                verticalLineTo(74.74f)
                curveTo(47.66f, 74.67f, 47.6f, 74.61f, 47.52f, 74.61f)
                curveTo(47.47f, 74.61f, 47.42f, 74.64f, 47.4f, 74.69f)
                curveTo(47.0f, 75.66f, 46.43f, 76.53f, 45.7f, 77.3f)
                curveTo(44.96f, 78.09f, 44.05f, 78.71f, 42.99f, 79.17f)
                curveTo(41.93f, 79.62f, 40.73f, 79.85f, 39.37f, 79.85f)
                close()
                moveTo(43.21f, 71.68f)
                curveTo(44.17f, 71.68f, 44.98f, 71.39f, 45.66f, 70.83f)
                curveTo(46.35f, 70.25f, 46.88f, 69.44f, 47.24f, 68.4f)
                curveTo(47.62f, 67.35f, 47.81f, 66.1f, 47.81f, 64.66f)
                curveTo(47.81f, 63.2f, 47.62f, 61.95f, 47.24f, 60.91f)
                curveTo(46.88f, 59.85f, 46.35f, 59.05f, 45.66f, 58.5f)
                curveTo(44.98f, 57.93f, 44.17f, 57.65f, 43.21f, 57.65f)
                curveTo(42.26f, 57.65f, 41.44f, 57.93f, 40.77f, 58.5f)
                curveTo(40.1f, 59.05f, 39.59f, 59.85f, 39.22f, 60.91f)
                curveTo(38.87f, 61.95f, 38.69f, 63.2f, 38.69f, 64.66f)
                curveTo(38.69f, 66.13f, 38.87f, 67.39f, 39.22f, 68.44f)
                curveTo(39.59f, 69.48f, 40.1f, 70.28f, 40.77f, 70.85f)
                curveTo(41.44f, 71.4f, 42.26f, 71.68f, 43.21f, 71.68f)
                close()
            }
            path(fill = radialGradient(0.0f to Color(0xFFFFFFFF), 1.0f to Color(0xFFE0E0E0), center
                    = Offset(60.0f,60.0f), radius = 32.0f), stroke = null, fillAlpha = 0.5f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(39.37f, 79.85f)
                curveTo(37.31f, 79.85f, 35.42f, 79.29f, 33.69f, 78.19f)
                curveTo(31.97f, 77.08f, 30.59f, 75.41f, 29.54f, 73.16f)
                curveTo(28.51f, 70.91f, 28.0f, 68.08f, 28.0f, 64.66f)
                curveTo(28.0f, 61.09f, 28.54f, 58.19f, 29.62f, 55.95f)
                curveTo(30.71f, 53.72f, 32.12f, 52.08f, 33.84f, 51.04f)
                curveTo(35.57f, 50.0f, 37.39f, 49.48f, 39.3f, 49.48f)
                curveTo(40.73f, 49.48f, 41.98f, 49.74f, 43.06f, 50.25f)
                curveTo(44.14f, 50.75f, 45.05f, 51.43f, 45.77f, 52.27f)
                curveTo(46.49f, 53.09f, 47.03f, 53.99f, 47.41f, 54.97f)
                curveTo(47.42f, 55.01f, 47.46f, 55.03f, 47.49f, 55.03f)
                curveTo(47.54f, 55.03f, 47.58f, 54.99f, 47.58f, 54.94f)
                verticalLineTo(45.2f)
                curveTo(47.58f, 42.33f, 49.91f, 40.0f, 52.78f, 40.0f)
                curveTo(55.65f, 40.0f, 57.98f, 42.33f, 57.98f, 45.2f)
                verticalLineTo(74.3f)
                curveTo(57.98f, 77.15f, 55.67f, 79.46f, 52.82f, 79.46f)
                horizontalLineTo(50.09f)
                curveTo(48.74f, 79.46f, 47.66f, 78.37f, 47.66f, 77.03f)
                verticalLineTo(74.74f)
                curveTo(47.66f, 74.67f, 47.6f, 74.61f, 47.52f, 74.61f)
                curveTo(47.47f, 74.61f, 47.42f, 74.64f, 47.4f, 74.69f)
                curveTo(47.0f, 75.66f, 46.43f, 76.53f, 45.7f, 77.3f)
                curveTo(44.96f, 78.09f, 44.05f, 78.71f, 42.99f, 79.17f)
                curveTo(41.93f, 79.62f, 40.73f, 79.85f, 39.37f, 79.85f)
                close()
                moveTo(43.21f, 71.68f)
                curveTo(44.17f, 71.68f, 44.98f, 71.39f, 45.66f, 70.83f)
                curveTo(46.35f, 70.25f, 46.88f, 69.44f, 47.24f, 68.4f)
                curveTo(47.62f, 67.35f, 47.81f, 66.1f, 47.81f, 64.66f)
                curveTo(47.81f, 63.2f, 47.62f, 61.95f, 47.24f, 60.91f)
                curveTo(46.88f, 59.85f, 46.35f, 59.05f, 45.66f, 58.5f)
                curveTo(44.98f, 57.93f, 44.17f, 57.65f, 43.21f, 57.65f)
                curveTo(42.26f, 57.65f, 41.44f, 57.93f, 40.77f, 58.5f)
                curveTo(40.1f, 59.05f, 39.59f, 59.85f, 39.22f, 60.91f)
                curveTo(38.87f, 61.95f, 38.69f, 63.2f, 38.69f, 64.66f)
                curveTo(38.69f, 66.13f, 38.87f, 67.39f, 39.22f, 68.44f)
                curveTo(39.59f, 69.48f, 40.1f, 70.28f, 40.77f, 70.85f)
                curveTo(41.44f, 71.4f, 42.26f, 71.68f, 43.21f, 71.68f)
                close()
            }
            path(fill = radialGradient(0.0f to Color(0xFFFFFFFF), 1.0f to Color(0xFFE0E0E0), center
                    = Offset(60.0f,60.0f), radius = 20.0f), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(77.01f, 80.0f)
                curveTo(73.87f, 80.0f, 71.19f, 79.36f, 68.95f, 78.09f)
                curveTo(66.72f, 76.81f, 65.01f, 75.02f, 63.81f, 72.74f)
                curveTo(62.62f, 70.44f, 62.02f, 67.77f, 62.02f, 64.74f)
                curveTo(62.02f, 61.71f, 62.62f, 59.05f, 63.81f, 56.76f)
                curveTo(65.01f, 54.46f, 66.72f, 52.68f, 68.95f, 51.41f)
                curveTo(71.19f, 50.12f, 73.87f, 49.48f, 77.01f, 49.48f)
                curveTo(80.15f, 49.48f, 82.84f, 50.12f, 85.07f, 51.41f)
                curveTo(87.31f, 52.68f, 89.02f, 54.46f, 90.21f, 56.76f)
                curveTo(91.4f, 59.05f, 92.0f, 61.71f, 92.0f, 64.74f)
                curveTo(92.0f, 67.77f, 91.4f, 70.44f, 90.21f, 72.74f)
                curveTo(89.02f, 75.02f, 87.31f, 76.81f, 85.07f, 78.09f)
                curveTo(82.84f, 79.36f, 80.15f, 80.0f, 77.01f, 80.0f)
                close()
                moveTo(77.09f, 72.14f)
                curveTo(77.97f, 72.14f, 78.73f, 71.84f, 79.37f, 71.23f)
                curveTo(80.01f, 70.63f, 80.5f, 69.77f, 80.85f, 68.65f)
                curveTo(81.2f, 67.53f, 81.38f, 66.2f, 81.38f, 64.66f)
                curveTo(81.38f, 63.11f, 81.2f, 61.78f, 80.85f, 60.67f)
                curveTo(80.5f, 59.56f, 80.01f, 58.7f, 79.37f, 58.09f)
                curveTo(78.73f, 57.49f, 77.97f, 57.19f, 77.09f, 57.19f)
                curveTo(76.16f, 57.19f, 75.36f, 57.49f, 74.7f, 58.09f)
                curveTo(74.03f, 58.7f, 73.52f, 59.56f, 73.17f, 60.67f)
                curveTo(72.82f, 61.78f, 72.64f, 63.11f, 72.64f, 64.66f)
                curveTo(72.64f, 66.2f, 72.82f, 67.53f, 73.17f, 68.65f)
                curveTo(73.52f, 69.77f, 74.03f, 70.63f, 74.7f, 71.23f)
                curveTo(75.36f, 71.84f, 76.16f, 72.14f, 77.09f, 72.14f)
                close()
            }
            path(fill = radialGradient(0.0f to Color(0xFFFFFFFF), 1.0f to Color(0xFFE0E0E0), center
                    = Offset(60.0f,60.0f), radius = 32.0f), stroke = null, fillAlpha = 0.5f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(77.01f, 80.0f)
                curveTo(73.87f, 80.0f, 71.19f, 79.36f, 68.95f, 78.09f)
                curveTo(66.72f, 76.81f, 65.01f, 75.02f, 63.81f, 72.74f)
                curveTo(62.62f, 70.44f, 62.02f, 67.77f, 62.02f, 64.74f)
                curveTo(62.02f, 61.71f, 62.62f, 59.05f, 63.81f, 56.76f)
                curveTo(65.01f, 54.46f, 66.72f, 52.68f, 68.95f, 51.41f)
                curveTo(71.19f, 50.12f, 73.87f, 49.48f, 77.01f, 49.48f)
                curveTo(80.15f, 49.48f, 82.84f, 50.12f, 85.07f, 51.41f)
                curveTo(87.31f, 52.68f, 89.02f, 54.46f, 90.21f, 56.76f)
                curveTo(91.4f, 59.05f, 92.0f, 61.71f, 92.0f, 64.74f)
                curveTo(92.0f, 67.77f, 91.4f, 70.44f, 90.21f, 72.74f)
                curveTo(89.02f, 75.02f, 87.31f, 76.81f, 85.07f, 78.09f)
                curveTo(82.84f, 79.36f, 80.15f, 80.0f, 77.01f, 80.0f)
                close()
                moveTo(77.09f, 72.14f)
                curveTo(77.97f, 72.14f, 78.73f, 71.84f, 79.37f, 71.23f)
                curveTo(80.01f, 70.63f, 80.5f, 69.77f, 80.85f, 68.65f)
                curveTo(81.2f, 67.53f, 81.38f, 66.2f, 81.38f, 64.66f)
                curveTo(81.38f, 63.11f, 81.2f, 61.78f, 80.85f, 60.67f)
                curveTo(80.5f, 59.56f, 80.01f, 58.7f, 79.37f, 58.09f)
                curveTo(78.73f, 57.49f, 77.97f, 57.19f, 77.09f, 57.19f)
                curveTo(76.16f, 57.19f, 75.36f, 57.49f, 74.7f, 58.09f)
                curveTo(74.03f, 58.7f, 73.52f, 59.56f, 73.17f, 60.67f)
                curveTo(72.82f, 61.78f, 72.64f, 63.11f, 72.64f, 64.66f)
                curveTo(72.64f, 66.2f, 72.82f, 67.53f, 73.17f, 68.65f)
                curveTo(73.52f, 69.77f, 74.03f, 70.63f, 74.7f, 71.23f)
                curveTo(75.36f, 71.84f, 76.16f, 72.14f, 77.09f, 72.14f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeAlpha = 0.16f, strokeLineWidth = 4.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(32.61f, 79.87f)
                lineTo(32.61f, 79.88f)
                curveTo(34.67f, 81.19f, 36.93f, 81.85f, 39.37f, 81.85f)
                curveTo(40.95f, 81.85f, 42.43f, 81.58f, 43.77f, 81.01f)
                lineTo(43.77f, 81.01f)
                lineTo(43.78f, 81.01f)
                curveTo(44.73f, 80.59f, 45.6f, 80.07f, 46.36f, 79.43f)
                curveTo(47.15f, 80.65f, 48.52f, 81.46f, 50.09f, 81.46f)
                horizontalLineTo(52.82f)
                curveTo(56.77f, 81.46f, 59.98f, 78.26f, 59.98f, 74.3f)
                verticalLineTo(45.2f)
                curveTo(59.98f, 41.22f, 56.75f, 38.0f, 52.78f, 38.0f)
                curveTo(48.8f, 38.0f, 45.58f, 41.22f, 45.58f, 45.2f)
                verticalLineTo(49.41f)
                curveTo(45.06f, 49.04f, 44.51f, 48.72f, 43.91f, 48.44f)
                curveTo(42.52f, 47.78f, 40.96f, 47.48f, 39.3f, 47.48f)
                curveTo(37.0f, 47.48f, 34.83f, 48.11f, 32.81f, 49.33f)
                lineTo(32.81f, 49.33f)
                lineTo(32.8f, 49.33f)
                curveTo(30.68f, 50.61f, 29.04f, 52.58f, 27.82f, 55.08f)
                lineTo(27.82f, 55.08f)
                lineTo(27.82f, 55.08f)
                curveTo(26.56f, 57.68f, 26.0f, 60.91f, 26.0f, 64.66f)
                curveTo(26.0f, 68.26f, 26.54f, 71.4f, 27.73f, 73.99f)
                lineTo(27.73f, 73.99f)
                lineTo(27.73f, 74.0f)
                curveTo(28.9f, 76.52f, 30.5f, 78.52f, 32.61f, 79.87f)
                close()
                moveTo(47.15f, 78.68f)
                lineTo(45.7f, 77.3f)
                lineTo(47.15f, 78.68f)
                curveTo(47.15f, 78.68f, 47.15f, 78.68f, 47.15f, 78.68f)
                close()
                moveTo(45.36f, 67.73f)
                lineTo(45.36f, 67.73f)
                lineTo(45.36f, 67.74f)
                curveTo(45.08f, 68.52f, 44.74f, 68.99f, 44.38f, 69.29f)
                curveTo(44.09f, 69.53f, 43.74f, 69.68f, 43.21f, 69.68f)
                curveTo(42.69f, 69.68f, 42.33f, 69.54f, 42.05f, 69.31f)
                curveTo(41.72f, 69.03f, 41.39f, 68.56f, 41.11f, 67.79f)
                curveTo(40.85f, 67.0f, 40.69f, 65.97f, 40.69f, 64.66f)
                curveTo(40.69f, 63.35f, 40.85f, 62.33f, 41.11f, 61.55f)
                curveTo(41.39f, 60.75f, 41.73f, 60.3f, 42.04f, 60.04f)
                lineTo(42.05f, 60.03f)
                curveTo(42.34f, 59.79f, 42.69f, 59.65f, 43.21f, 59.65f)
                curveTo(43.74f, 59.65f, 44.09f, 59.79f, 44.38f, 60.03f)
                lineTo(44.4f, 60.05f)
                lineTo(44.41f, 60.06f)
                curveTo(44.74f, 60.32f, 45.08f, 60.77f, 45.35f, 61.56f)
                lineTo(45.36f, 61.57f)
                lineTo(45.36f, 61.59f)
                curveTo(45.64f, 62.35f, 45.81f, 63.36f, 45.81f, 64.66f)
                curveTo(45.81f, 65.93f, 45.64f, 66.94f, 45.36f, 67.73f)
                close()
                moveTo(67.96f, 79.83f)
                lineTo(67.96f, 79.83f)
                curveTo(70.56f, 81.31f, 73.6f, 82.0f, 77.01f, 82.0f)
                curveTo(80.42f, 82.0f, 83.46f, 81.31f, 86.06f, 79.83f)
                lineTo(86.07f, 79.83f)
                curveTo(88.63f, 78.35f, 90.62f, 76.29f, 91.98f, 73.66f)
                lineTo(91.99f, 73.66f)
                curveTo(93.35f, 71.03f, 94.0f, 68.04f, 94.0f, 64.74f)
                curveTo(94.0f, 61.44f, 93.35f, 58.46f, 91.99f, 55.84f)
                curveTo(90.62f, 53.2f, 88.63f, 51.13f, 86.06f, 49.67f)
                curveTo(83.47f, 48.18f, 80.42f, 47.48f, 77.01f, 47.48f)
                curveTo(73.6f, 47.48f, 70.56f, 48.18f, 67.96f, 49.67f)
                curveTo(65.39f, 51.13f, 63.41f, 53.2f, 62.04f, 55.84f)
                curveTo(60.67f, 58.46f, 60.02f, 61.44f, 60.02f, 64.74f)
                curveTo(60.02f, 68.04f, 60.67f, 71.03f, 62.04f, 73.66f)
                lineTo(62.04f, 73.66f)
                curveTo(63.41f, 76.29f, 65.39f, 78.35f, 67.96f, 79.83f)
                close()
                moveTo(78.95f, 61.27f)
                lineTo(78.95f, 61.28f)
                curveTo(79.22f, 62.14f, 79.38f, 63.25f, 79.38f, 64.66f)
                curveTo(79.38f, 66.06f, 79.22f, 67.18f, 78.95f, 68.05f)
                curveTo(78.66f, 68.95f, 78.32f, 69.47f, 77.99f, 69.78f)
                lineTo(79.37f, 71.23f)
                lineTo(77.99f, 69.78f)
                curveTo(77.72f, 70.03f, 77.46f, 70.14f, 77.09f, 70.14f)
                curveTo(76.64f, 70.14f, 76.32f, 70.01f, 76.04f, 69.75f)
                curveTo(75.71f, 69.45f, 75.36f, 68.93f, 75.08f, 68.05f)
                curveTo(74.8f, 67.18f, 74.64f, 66.06f, 74.64f, 64.66f)
                curveTo(74.64f, 63.25f, 74.8f, 62.14f, 75.08f, 61.28f)
                lineTo(75.08f, 61.27f)
                curveTo(75.36f, 60.4f, 75.71f, 59.88f, 76.04f, 59.57f)
                curveTo(76.32f, 59.32f, 76.64f, 59.19f, 77.09f, 59.19f)
                curveTo(77.46f, 59.19f, 77.72f, 59.29f, 77.99f, 59.55f)
                curveTo(78.32f, 59.85f, 78.66f, 60.38f, 78.95f, 61.27f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(60.0f, 60.0f)
                moveToRelative(-51.25f, 0.0f)
                arcToRelative(51.25f, 51.25f, 0.0f, true, true, 102.5f, 0.0f)
                arcToRelative(51.25f, 51.25f, 0.0f, true, true, -102.5f, 0.0f)
            }
        }
        .build()
        return _dodoong!!
    }

private var _dodoong: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Dodoong, contentDescription = "")
    }
}
