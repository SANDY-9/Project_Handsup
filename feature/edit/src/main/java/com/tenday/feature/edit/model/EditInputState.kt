package com.tenday.feature.edit.model

data class EditInputState(
    val pwdInput: String,
    val pwdConfirmInput: String,
    val pwdError: Boolean,
    val pwdConfirmError: Boolean,
)
