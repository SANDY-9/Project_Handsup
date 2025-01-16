package com.tenday.feature.login

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.addFocusCleaner
import com.tenday.designsystem.utils.StatusBarStyle
import com.tenday.feature.login.components.LoginButton
import com.tenday.feature.login.components.LoginEmptyValueMessage
import com.tenday.feature.login.components.LoginErrorMessage
import com.tenday.feature.login.components.LoginInputBox
import com.tenday.feature.login.components.LoginTitle
import com.tenday.feature.login.model.LoginUiState
import com.tenday.feature.login.model.LoginUiState.Companion.enabled
import com.tenday.feature.login.model.LoginUiState.Companion.error
import com.tenday.feature.login.model.LoginUiState.Companion.loading

@Composable
internal fun LoginRoute(
    onSuccessLogin: () -> Unit,
    onFinish: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    BackHandler(enabled = true) { onFinish() }
    StatusBarStyle(false)

    val idInputState by loginViewModel.idInput.collectAsStateWithLifecycle()
    val pwdInputState by loginViewModel.pwdInput.collectAsStateWithLifecycle()
    val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()
    LaunchedEffect(loginUiState) {
        if(loginUiState is LoginUiState.Success) {
            onSuccessLogin()
        }
    }
    LoginScreen(
        loginUiState = loginUiState,
        id = idInputState,
        pwd = pwdInputState,
        onIdInputChange = loginViewModel::onIdInputChanged,
        onPwdInputChange = loginViewModel::onPwdInputChanged,
        onLogin = loginViewModel::requestLogin,
    )
}

@Composable
internal fun LoginScreen(
    loginUiState: LoginUiState,
    id: String,
    pwd: String,
    onIdInputChange: (String) -> Unit,
    onPwdInputChange: (String) -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current

    LaunchedEffect(loginUiState) {
        if(loginUiState is LoginUiState.Loading) {
            focusManager.clearFocus()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.margin20)
            .addFocusCleaner(focusManager),
    ) {
        Spacer(modifier = modifier.fillMaxHeight(0.2f))
        LoginTitle()
        Spacer(modifier = modifier.height(Dimens.margin16))
        LoginInputBox(
            id = id,
            pwd = pwd,
            error = loginUiState.error(),
            onPwdInputChange = onPwdInputChange,
            onIdInputChange = onIdInputChange,
        )
        AnimatedVisibility(loginUiState is LoginUiState.EmptyValue,) {
            LoginEmptyValueMessage()
        }
        AnimatedVisibility(loginUiState is LoginUiState.Fail) {
            LoginErrorMessage()
        }
        Spacer(modifier = modifier.height(Dimens.margin24))
        LoginButton(
            enabled = loginUiState.enabled(),
            loading = loginUiState.loading(),
            onLogin = onLogin,
        )
    }
}

@Preview(name = "LoginScreen")
@Composable
private fun PreviewLoginScreen() {
    var id by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    LoginScreen(
        LoginUiState.Ready,
        id,
        pwd,
        { id = it },
        { pwd = pwd },
        {},
    )
}