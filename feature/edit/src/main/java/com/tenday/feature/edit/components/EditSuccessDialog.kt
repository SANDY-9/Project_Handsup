package com.tenday.feature.edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.designsystem.components.HandsUpDialog
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.edit.R
import com.tenday.feature.edit.model.UpdateType

@Composable
internal fun EditSuccessDialog(
    updateType: UpdateType,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    HandsUpDialog {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimens.margin20),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = modifier.height(Dimens.margin8))
            Text(
                text = stringResource(
                    R.string.edit_dialog_success_title,
                    updateType.desc
                ),
                style = HandsUpTypography.title4.copy(
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = modifier.height(Dimens.margin6))
            Text(
                text = stringResource(
                    R.string.edit_dialog_success_desc,
                    updateType.desc
                ),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.Medium,
                    color = Gray700,
                )
            )
            Spacer(modifier = modifier.height(Dimens.margin24))
            HandsUpButton(
                text = stringResource(R.string.edit_dialog_success_close),
                enabled = true,
                onClick = onCancel,
            )
        }
    }
}

@Preview(name = "EditDialog")
@Composable
private fun PreviewEditDialog() {
    EditSuccessDialog(
        updateType = UpdateType.PASSWORD,
        {},
    )
}