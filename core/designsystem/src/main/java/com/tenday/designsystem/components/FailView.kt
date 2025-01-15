package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.icons.Info
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray300
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.designsystem.utils.StatusBarStyle

@Composable
fun HandsUpFailView(
    modifier: Modifier = Modifier,
) {
    StatusBarStyle(false)
    Column (
        modifier = modifier.fillMaxSize()
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = modifier.weight(1f))
        Icon(
            modifier = modifier.size(24.dp),
            imageVector = Icons.Info,
            contentDescription = null,
            tint = Gray300,
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            text = "네트워크 연결 상태를 확인해주세요.",
            style = HandsUpTypography.body3,
            color = Gray500
        )
        Spacer(modifier = modifier.weight(0.5f))
        Icon(
            imageVector = Icons.HandsUpLogo,
            contentDescription = null,
            tint = Gray100,
        )
        Spacer(modifier = modifier.weight(1f))
    }
}

@Preview
@Composable
private fun Preview() {
    HandsUpFailView()
}