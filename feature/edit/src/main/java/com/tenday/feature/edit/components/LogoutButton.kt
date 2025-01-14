package com.tenday.feature.edit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.White
import com.tenday.feature.edit.R

@Composable
internal fun LogoutButton(
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(
            top = Dimens.margin10,
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin20
        )
    ) {
        HandsUpButton(
            text = stringResource(R.string.edit_btn_logout_title),
            enabled = true,
            onClick = onLogout,
            btnColor = White,
            textColor = Gray900,
        )
    }
}

@Preview(name = "LogoutButton")
@Composable
private fun PreviewLogoutButton() {
    LogoutButton({})
}