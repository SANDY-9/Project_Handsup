package com.tenday.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.icons.ArrowBack
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
fun HandsUpTitleTopBar(
    content: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(56.dp),
        contentAlignment = Alignment.Center,
        content = content,
    )
}

@Composable
fun HandsUpNavigateTopBar(
    title: String,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpTitleTopBar(
        content = {
            Icon(
                modifier = modifier.size(24.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)
                    .clickable(onClick = onNavigate),
                imageVector = Icons.ArrowBack,
                contentDescription = null,
            )
            Text(
                text = title,
                style = HandsUpTypography.title4,
            )
        }
    )
}

@Composable
@Preview
private fun Preview() {
    HandsUpNavigateTopBar(
        "알람",
        {}
    )
}