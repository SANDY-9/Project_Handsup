package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.ArrowBack
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.LinearGradientOrangeBold
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun ExpMissionBanner(
    userName: String,
    onBannerClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = LinearGradientOrangeBold,
                shape = RoundedCornerShape(Dimens.cornerShape12)
            )
            .clip(
                shape = RoundedCornerShape(Dimens.cornerShape12)
            ).clickable(
                onClick = onBannerClick,
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
        Spacer(modifier = modifier.width(20.dp))
        Icon(
            modifier = modifier.size(24.dp).rotate(180f),
            imageVector = Icons.ArrowBack,
            contentDescription = null,
            tint = White,
        )
    }
}

@Preview(name = "ExpMissionBanner")
@Composable
private fun PreviewExpMissionBanner() {
    ExpMissionBanner("김민수", {})
}