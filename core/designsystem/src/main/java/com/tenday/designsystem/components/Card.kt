package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.R
import com.tenday.designsystem.components.HandsUpTextureCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.theme.CardShadow
import com.tenday.designsystem.theme.LinearGradientOrange
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpShadowCard(
    content: @Composable (ColumnScope.() -> Unit),
    cornerSize: Dp = Dimens.cornerShape12,
    elevationSize: Dp = Dimens.cornerShape8,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    clickable: Boolean = false,
    onClick: () -> Unit = {},
    shadowColor: Color = CardShadow,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.blurShadow(
            borderRadius = cornerSize,
            blurRadius = elevationSize,
            offsetY = offsetY,
            offsetX = offsetX,
            color = shadowColor,
        ),
        shape = RoundedCornerShape(cornerSize),
        colors = CardDefaults.cardColors(
            containerColor = White,
            disabledContainerColor = White,
        ),
        enabled = clickable,
        onClick = onClick,
        content = content,
    )
}

@Composable
fun HandsUpTextureCard(
    cornerSize: Dp = Dimens.cornerShape12,
    gradient: Brush = LinearGradientOrange,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Box (
        modifier = Modifier.background(
            brush = gradient,
            shape = RoundedCornerShape(cornerSize),
        )
    ) {
        Box(
            modifier = Modifier.matchParentSize().paint(
                painter = painterResource(R.drawable.texture_background),
                contentScale = ContentScale.FillBounds,
            )
        )
        Column(
            modifier = modifier,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
        ) {
            content.invoke(this)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    /*HandsUpShadowCard({}, modifier = Modifier
        .size(100.dp)
        .padding(20.dp)
    )*/
    HandsUpTextureCard(
        modifier = Modifier.padding(30.dp)
    ) {
        Text("테스트")
    }
}