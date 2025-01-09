package com.tenday.feature.login.login.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.feature.login.R

@Composable
internal fun LoginButton(
    enabled: Boolean,
    onLogin: () -> Unit,
) {
    HandsUpButton(
        text = stringResource(R.string.login_title),
        enabled = enabled,
        onClick = onLogin
    )
}

@Preview(name = "LoginButton")
@Composable
private fun PreviewLoginButton() {
    LoginButton(true, {})
}