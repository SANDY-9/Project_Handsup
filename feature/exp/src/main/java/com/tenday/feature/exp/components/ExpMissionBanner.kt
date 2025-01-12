package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun ExpMissionBanner(
    userName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.margin20,
                vertical = Dimens.margin12,
            )
            .background(
                color = HandsUpOrange,
                shape = RoundedCornerShape(Dimens.cornerShape12)
            )
            .padding(
                horizontal = Dimens.margin20,
                vertical = Dimens.margin16,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.exp_banner_desc, userName),
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.SemiBold,
                color = White,
            )
        )
        Spacer(modifier = modifier.weight(1f))
        Image(
            modifier = modifier.size(48.dp),
            imageVector = Icons.Dodoong,
            contentDescription = null,
        )
    }
}

@Preview(name = "ExpMissionBanner")
@Composable
private fun PreviewExpMissionBanner() {
    ExpMissionBanner("김민수")
}