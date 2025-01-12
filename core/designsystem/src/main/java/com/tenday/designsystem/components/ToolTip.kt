package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.theme.HandsUpNavy

@Composable
fun HandsUpToolTip(
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Column(
        horizontalAlignment = Alignment.End,
    ) {
        Icon(
            modifier = Modifier.padding(end = 40.dp),
            imageVector = Triangle,
            contentDescription = null,
            tint = HandsUpNavy
        )
        Column(
            modifier = modifier.background(
                color = HandsUpNavy,
                shape = RoundedCornerShape(Dimens.cornerShape4),
            ).padding(
                top = Dimens.margin10,
                bottom = Dimens.margin12,
                start = Dimens.margin12,
                end = Dimens.margin12,
            ),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
        ) {
            content.invoke(this)
        }
    }
}

private val Triangle: ImageVector
    get() {
        if (_triangle != null) {
            return _triangle!!
        }
        _triangle = Builder(name = "Triangle", defaultWidth = 10.0.dp, defaultHeight = 6.0.dp,
            viewportWidth = 10.0f, viewportHeight = 6.0f).apply {
            path(fill = SolidColor(Color(0xFF445368)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero) {
                moveTo(0.0f, 6.0f)
                lineTo(5.0f, 0.0f)
                lineTo(10.0f, 6.0f)
                horizontalLineTo(0.0f)
                close()
            }
        }
            .build()
        return _triangle!!
    }

private var _triangle: ImageVector? = null

@Composable
@Preview
private fun Preview() {
    HandsUpToolTip(
        modifier = Modifier.width(200.dp),
    )  {
        Text("테스트")
        Text("테스트")
        Text("테스트")
    }
}