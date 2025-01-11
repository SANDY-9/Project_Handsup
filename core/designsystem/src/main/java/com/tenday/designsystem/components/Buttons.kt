package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.blurShadow
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.theme.CardShadowSemiLight
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.Gray600
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
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
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

@Composable
fun HandsUpTabButton(
    title: String,
    selected: Boolean,
    onSelectClick: () -> Unit,
    onUnselectClick: () -> Unit,
) {
    when {
        selected -> SelectedTabButton(title, onSelectClick)
        else -> UnselectedTabButton(title, onUnselectClick)
    }
}

@Composable
private fun SelectedTabButton(
    title: String,
    onSelectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .blurShadow(
                borderRadius = Dimens.cornerShape8,
                blurRadius = 4.dp,
                offsetY = 2.dp,
                color = CardShadowSemiLight,
            )
            .background(
                color = White,
                shape = RoundedCornerShape(Dimens.cornerShape8),
            )
            .clip(
                shape = RoundedCornerShape(Dimens.cornerShape8),
            )
            .clickable(
                onClick = onSelectClick,
            )
            .padding(
                horizontal = Dimens.margin11,
                vertical = Dimens.margin8,
            )
    ) {
        Text(
            text = title,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
                color = HandsUpOrange,
            )
        )
    }
}

@Composable
private fun UnselectedTabButton(
    title: String,
    onUnselectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .noRippleClickable(
                onClick = onUnselectClick
            )
            .padding(
                horizontal = Dimens.margin11,
                vertical = Dimens.margin8,
            )
    ) {
        Text(
            text = title,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Medium,
                color = Gray600,
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    var selected by remember { mutableStateOf(true) }
    HandsUpTheme {
        Column(
            modifier = Modifier.background(
                color = Gray100
            ).padding(10.dp)
        ) {
            HandsUpButton(
                text = "로그인",
                false,
                {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            HandsUpTabButton(
                "리더부여",
                selected,
                { selected = !selected },
                { selected = !selected },
            )
        }
    }
}