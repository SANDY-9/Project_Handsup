package com.tenday.feature.edit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.designsystem.components.HandsUpInputBox
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.Negative
import com.tenday.feature.edit.R

@Composable
internal fun EditPasswordView(
    pwd: String,
    pwdConfirm: String,
    pwdError: Boolean,
    pwdConfirmError: Boolean,
    onPwdInputChange: (String) -> Unit,
    onPwdConfirmInputChange: (String) -> Unit,
    onEditComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(
            horizontal = Dimens.margin20
        )
    ) {
        HandsUpShadowCard(
            shadowColor = CardShadowLight,
            offsetY = 2.dp,
            content = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(Dimens.margin20)
                    ,
                ) {
                    Text(
                        text = stringResource(R.string.edit_pwd_title),
                        style = HandsUpTypography.title5,
                    )
                    Spacer(modifier = modifier.height(Dimens.margin12))
                    HandsUpInputBox(
                        input = pwd,
                        onInputChange = onPwdInputChange,
                        placeHolder = stringResource(R.string.edit_pwd_placeholder),
                        pwdMode = true,
                        error = pwdError,
                    )
                    if(pwdError) {
                        Text(
                            modifier = modifier.padding(top = Dimens.margin6),
                            text = stringResource(R.string.edit_pwd_error),
                            style = HandsUpTypography.body3.copy(
                                fontWeight = FontWeight.Medium,
                                color = Negative,
                            ),
                        )
                    }
                    Spacer(modifier = modifier.height(Dimens.margin8))
                    HandsUpInputBox(
                        input = pwdConfirm,
                        onInputChange = onPwdConfirmInputChange,
                        placeHolder = stringResource(R.string.edit_pwd_confirm_placeholder),
                        pwdMode = true,
                        error = pwdConfirmError,
                    )
                    if(pwdConfirmError) {
                        Text(
                            modifier = modifier.padding(top = Dimens.margin6),
                            text = stringResource(R.string.edit_pwd_confirm_error),
                            style = HandsUpTypography.body3.copy(
                                fontWeight = FontWeight.Medium,
                                color = Negative,
                            ),
                        )
                    }
                    Spacer(modifier = modifier.height(Dimens.margin12))
                    HandsUpButton(
                        text = stringResource(R.string.edit_btn_complete_title),
                        enabled = !pwdError && !pwdConfirmError,
                        onClick = onEditComplete,
                    )
                }
            }
        )
    }
}

@Preview(name = "EditPasswordView")
@Composable
private fun PreviewEditPasswordView() {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    EditPasswordView(
        onEditComplete = {},
        pwd = input1,
        pwdConfirm = input2,
        pwdError = false,
        pwdConfirmError = false,
        onPwdInputChange = {input1 = it},
        onPwdConfirmInputChange = {input2 = it},
    )
}