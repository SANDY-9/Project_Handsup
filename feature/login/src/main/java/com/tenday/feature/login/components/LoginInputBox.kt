package com.tenday.feature.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpInputBox
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.login.R

@Composable
internal fun LoginInputBox(
    id: String,
    pwd: String,
    error: Boolean,
    onIdInputChange: (String) -> Unit,
    onPwdInputChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        HandsUpInputBox(
            input = id,
            onInputChange = onIdInputChange,
            placeHolder = stringResource(R.string.login_id_placeholder),
            error = error
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
        HandsUpInputBox(
            input = pwd,
            onInputChange = onPwdInputChange,
            pwdMode = true,
            placeHolder = stringResource(R.string.login_pwd_placeholder),
            error = error,
        )
    }
}

@Preview(name = "LoginInputBox")
@Composable
private fun PreviewLoginInputBox() {
    var id by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    LoginInputBox(
        id,
        pwd,
        true,
        { id = it },
        { pwd = pwd },
    )
}