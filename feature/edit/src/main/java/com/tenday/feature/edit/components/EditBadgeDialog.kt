package com.tenday.feature.edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.designsystem.components.HandsUpDialog
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.svgImageLoader
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.edit.R

@Composable
internal fun EditBadgeDialog(
    selectBadge: BadgeCode,
    onCancel: () -> Unit,
    onComplete: (BadgeCode) -> Unit,
    modifier: Modifier = Modifier,
) {
    HandsUpDialog {
        Column(
            modifier = modifier.fillMaxWidth().padding(Dimens.margin20),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.margin8)
        ) {
            Spacer(modifier = modifier.height(Dimens.margin8))
            Image(
                modifier = modifier.size(64.dp),
                painter = svgImageLoader(selectBadge.resFilePath),
                contentDescription = null,
            )
            Text(
                text = selectBadge.badgeName,
                style = HandsUpTypography.title4
            )
            Text(
                text = selectBadge.desc,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.Medium,
                    color = Gray700,
                ),
                maxLines = 2,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
            Row {
                HandsUpButton(
                    modifier = modifier.weight(1f),
                    text = stringResource(R.string.edit_dialog_edit_cancel),
                    enabled = true,
                    onClick = onCancel,
                    btnColor = Gray100,
                    textColor = Gray900,
                )
                Spacer(modifier = modifier.width(Dimens.margin8))
                HandsUpButton(
                    modifier = modifier.weight(1f),
                    text = stringResource(R.string.edit_badge_edit_ok),
                    enabled = true,
                    onClick = {
                        onComplete(selectBadge)
                    },
                )
            }
        }
    }
}

@Preview(name = "EditBadgeDialog")
@Composable
private fun PreviewEditBadgeDialog() {
    EditBadgeDialog(
        selectBadge = BadgeCode.EXP_EVERY_MONTH_FOR_A_YEAR,
        {},
        {},
    )
}