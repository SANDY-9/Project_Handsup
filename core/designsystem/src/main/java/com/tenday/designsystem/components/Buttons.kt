package com.tenday.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTheme
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.height(56.dp).fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonColors(
            containerColor = HandsUpOrange,
            contentColor = White,
            disabledContainerColor = Gray500,
            disabledContentColor = White,
        ),
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = HandsUpTypography.title5
        )
    }
}

@Preview
@Composable
private fun Preview() {
    HandsUpTheme {
        HandsUpButton(
            text = "로그인",
            false,
            {}
        )
    }
}