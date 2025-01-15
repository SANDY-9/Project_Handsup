package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.White
import com.tenday.designsystem.utils.StatusBarStyle

@Composable
fun HandsUpLoadingView(
    modifier: Modifier = Modifier,
) {
    StatusBarStyle(false)
    Column (
        modifier = modifier.fillMaxSize()
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(24.dp),
            color = Gray100,
            strokeWidth = (3.5).dp,
            strokeCap = StrokeCap.Round,
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
        Icon(
            imageVector = Icons.HandsUpLogo,
            contentDescription = null,
            tint = Gray100,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    HandsUpLoadingView()
}