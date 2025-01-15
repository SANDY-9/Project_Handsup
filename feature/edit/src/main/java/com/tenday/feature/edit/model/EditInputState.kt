package com.tenday.feature.edit.model

internal data class EditInputState(
    val pwdInput: String,
    val pwdConfirmInput: String,
    val pwdError: Boolean,
    val pwdConfirmError: Boolean,
) {
    companion object {
        fun EditInputState.disabled() = pwdError || pwdConfirmError || pwdInput.isBlank()
    }
}
