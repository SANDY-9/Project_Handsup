package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.tenday.designsystem.theme.TransparentWhite80
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    btnColor: Color = HandsUpOrange,
    textColor: Color = White,
    loading: Boolean = false,
) {
    Button(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.cornerShape12),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonColors(
            containerColor = btnColor,
            contentColor = textColor,
            disabledContainerColor = Gray500,
            disabledContentColor = White,
        ),
        enabled = enabled,
        onClick = onClick,
    ) {
        when {
            loading -> CircularProgressIndicator(
                modifier = modifier.size(24.dp),
                color = TransparentWhite80,
                strokeWidth = (3.5).dp,
                strokeCap = StrokeCap.Round,
            )

            else -> Text(
                text = text,
                style = HandsUpTypography.title5,
                color = textColor,
            )
        }
    }
}

@Composable
fun HandsUpTabButton(
    title: String,
    selected: Boolean,
    onUnselectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when {
        selected -> SelectedTabButton(title, modifier)
        else -> UnselectedTabButton(title, onUnselectClick, modifier)
    }
}

@Composable
private fun SelectedTabButton(
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
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
            .padding(
                vertical = Dimens.margin8,
            )
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = title,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
                color = HandsUpOrange,
            ),
            textAlign = TextAlign.Center,
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
            .fillMaxWidth()
            .noRippleClickable(
                onClick = onUnselectClick
            )
            .padding(
                vertical = Dimens.margin8,
            )
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = title,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Medium,
                color = Gray600,
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    var selected by remember { mutableStateOf(true) }
    HandsUpTheme {
        Column(
            modifier = Modifier
                .background(
                    color = Gray100
                )
                .padding(10.dp)
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
            )
        }
    }
}