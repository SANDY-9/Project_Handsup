package com.tenday.feature.edit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray200
import com.tenday.designsystem.theme.Gray300
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.edit.R

@Composable
internal fun EditPushSettings(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(
            horizontal = Dimens.margin20,
            vertical = Dimens.margin12,
        )
    ) {
        HandsUpShadowCard(
            content = {
                Row(
                    modifier = modifier.padding(
                        vertical = Dimens.margin12,
                        horizontal = Dimens.margin20,
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.edit_set_push_title),
                        style = HandsUpTypography.title5,
                    )
                    Spacer(modifier = modifier.weight(1f))
                    Switch(
                        modifier = modifier.size(width = 52.dp, height = 28.dp),
                        checked = checked,
                        onCheckedChange = onCheckedChange,
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = HandsUpOrange,
                            checkedBorderColor = White,
                            uncheckedTrackColor = Gray200,
                            uncheckedBorderColor = White,
                            uncheckedThumbColor = Gray300,
                        ),
                    )
                }
            }
        )
    }
}

@Preview(name = "EditPushSettings")
@Composable
private fun PreviewEditPushSettings() {
    EditPushSettings(
        false,
        {},
    )
}