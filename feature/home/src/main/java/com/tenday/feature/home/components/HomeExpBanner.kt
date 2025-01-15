package com.tenday.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.ArrowCircle
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.home.R

@Composable
internal fun HomeExpBanner(
    onBannerClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    HandsUpShadowCard(
        cornerSize = Dimens.cornerShape8,
        content = {
            Column(
                modifier = modifier
                    .size(
                        width = 114.dp,
                        height = 127.dp,
                    )
                    .padding(
                        horizontal = Dimens.margin12,
                        vertical = Dimens.margin16,
                    ).clip(
                        RoundedCornerShape(Dimens.cornerShape8)
                    ).clickable(
                        onClick = onBannerClick
                    )
            ) {
                Text(
                    text = stringResource(R.string.home_exp_banner_title1),
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Spacer(modifier = modifier.height(Dimens.margin1))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(Dimens.margin20),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.home_exp_banner_title2),
                        style = HandsUpTypography.body2.copy(
                            fontWeight = FontWeight.Black,
                            color = HandsUpOrange
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = modifier.width(Dimens.margin2))
                    Image(
                        modifier = modifier.size(16.dp),
                        imageVector = Icons.Dodoong,
                        contentDescription = null,
                    )
                }
                Spacer(modifier = modifier.height(Dimens.margin1))
                Text(
                    text = stringResource(R.string.home_exp_banner_title3),
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Spacer(modifier = modifier.weight(1f))
                Box(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Icon(
                        modifier = modifier
                            .align(Alignment.CenterEnd)
                            .size(16.dp),
                        imageVector = Icons.ArrowCircle,
                        contentDescription = null,
                        tint = HandsUpOrange,
                    )
                }
            }
        }
    )
}

@Preview(name = "HomeExpBanner")
@Composable
private fun PreviewHomeExpBanner() {
    HomeExpBanner({})
}