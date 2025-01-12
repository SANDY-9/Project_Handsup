package com.tenday.feature.login.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.Negative
import com.tenday.feature.login.R

@Composable
internal fun LoginErrorMessage(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.padding(top = Dimens.margin6),
        text = stringResource(R.string.login_error),
        style = HandsUpTypography.body3,
        color = Negative,
    )
}

@Composable
internal fun LoginEmptyValueMessage(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.padding(top = Dimens.margin6),
        text = stringResource(R.string.login_empty_value),
        style = HandsUpTypography.body3,
        color = Negative,
    )
}
