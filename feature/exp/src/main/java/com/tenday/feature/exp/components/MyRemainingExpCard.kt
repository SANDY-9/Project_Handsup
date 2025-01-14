package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.HandsUpNavy
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.TransparentWhite16
import com.tenday.designsystem.theme.TransparentWhite8
import com.tenday.designsystem.theme.TransparentWhite80
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun MyRemainingExpCard(
    currentExp: Int,
    requireExp: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(
                color = TransparentWhite16,
                shape = RoundedCornerShape(Dimens.margin8),
            )
            .padding(Dimens.margin12),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.exp_remain_total_title),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = TransparentWhite80,
            )
            Spacer(modifier = modifier.height(Dimens.margin4))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = currentExp.toData(),
                    style = HandsUpTypography.body1.copy(
                        fontWeight = FontWeight.ExtraBold,
                    ),
                    color = White,
                )
                Spacer(modifier = modifier.width(Dimens.margin2))
                Image(
                    modifier = modifier.size(16.dp),
                    imageVector = Icons.Dodoong,
                    contentDescription = null,
                )
            }
        }
        VerticalDivider(
            modifier = Modifier.padding(horizontal = 8.dp),
            color = TransparentWhite8,
        )
        Column(
            modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.exp_remain_next_title),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = White,
            )
            Spacer(modifier = modifier.height(Dimens.margin4))
            Row {
                Text(
                    text = requireExp.toData(),
                    style = HandsUpTypography.body1.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
                    color = White,
                )
                Spacer(modifier = modifier.width(Dimens.margin2))
                Image(
                    modifier = modifier.size(16.dp),
                    imageVector = Icons.Dodoong,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(name = "MyRemainingExpCard")
@Composable
private fun PreviewMyRemainingExpCard() {
    Box(
        modifier = Modifier
            .background(color = HandsUpNavy)
            .padding(20.dp)
    ) {
        MyRemainingExpCard(14000, 13000)
    }
}