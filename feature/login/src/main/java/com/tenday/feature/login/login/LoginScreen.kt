package com.tenday.feature.login.login

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.login.login.components.LoginButton
import com.tenday.feature.login.login.components.LoginEmptyValueMessage
import com.tenday.feature.login.login.components.LoginErrorMessage
import com.tenday.feature.login.login.components.LoginInputBox
import com.tenday.feature.login.login.components.LoginTitle
import com.tenday.feature.login.login.model.LoginUiState

@Composable
internal fun LoginRoute(
    onSuccessLogin: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
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
        onIdInputChange = loginViewModel::onIdInputChanged,
        pwd = pwdInputState,
        onPwdInputChange = loginViewModel::onPwdInputChanged,
        onLogin = loginViewModel::requestLogin,
    )
}

@Composable
internal fun LoginScreen(
    loginUiState: LoginUiState,
    id: String,
    onIdInputChange: (String) -> Unit,
    pwd: String,
    onPwdInputChange: (String) -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.margin20),
    ) {
        Spacer(modifier = modifier.fillMaxHeight(0.2f))
        LoginTitle()
        Spacer(modifier = modifier.height(Dimens.margin16))
        LoginInputBox(
            id = id,
            onIdInputChange = onIdInputChange,
            pwd = pwd,
            onPwdInputChange = onPwdInputChange,
        )
        if(loginUiState is LoginUiState.EmptyValue) {
            LoginEmptyValueMessage()
        }
        if(loginUiState is LoginUiState.Fail) {
            LoginErrorMessage()
        }
        Spacer(modifier = modifier.height(Dimens.margin24))
        LoginButton(
            enabled = loginUiState !is LoginUiState.Loading,
            onLogin = onLogin
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
        { id = it },
        pwd,
        { pwd = pwd },
        {},
    )
}