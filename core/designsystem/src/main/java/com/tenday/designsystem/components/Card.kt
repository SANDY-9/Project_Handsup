package com.tenday.designsystem.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.CardShadow
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpShadowCard(
    content: @Composable (ColumnScope.() -> Unit),
    cornerSize: Dp = Dimens.cornerShape12,
    elevationSize: Dp = Dimens.cornerShape8,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.shadow(
            shape = RoundedCornerShape(cornerSize),
            ambientColor = CardShadow,
            elevation = elevationSize,
            spotColor = CardShadow,
        ),
        shape = RoundedCornerShape(cornerSize),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        content = content,
    )
}

@Preview
@Composable
private fun Preview() {
    HandsUpShadowCard({}, modifier = Modifier
        .size(100.dp)
        .padding(20.dp))
}