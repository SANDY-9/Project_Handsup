package com.tenday.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.theme.Gray200
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
fun HandsUpInputBox(
    input: String,
    onInputChange: (String) -> Unit,
    placeHolder: String = "",
    pwdMode: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val visualTransformation = remember {
        if(pwdMode) PasswordVisualTransformation('●')
        else VisualTransformation.None
    }
    OutlinedTextField(
        value = input,
        onValueChange = onInputChange,
        modifier = modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = HandsUpOrange,
            unfocusedBorderColor = Gray200,
            cursorColor = HandsUpOrange,
            focusedTextColor = Gray900,
            unfocusedTextColor = Gray900,
            focusedPlaceholderColor = Gray500,
            unfocusedPlaceholderColor = Gray500,
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = placeHolder,
                style = HandsUpTypography.body1,
            )
        },
        prefix = {
            Text(" ")
        },
        textStyle = HandsUpTypography.body1,
        visualTransformation = visualTransformation,
    )

}

@Preview
@Composable
private fun Preview() {
    var input by remember { mutableStateOf("") }
    HandsUpInputBox(
        input = input,
        onInputChange = { input = it },
        pwdMode = true,
    )
}