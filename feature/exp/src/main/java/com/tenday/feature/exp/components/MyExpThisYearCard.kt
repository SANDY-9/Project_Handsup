package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.ExpCircularGraph
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.Backgroud
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.exp.R

@Composable
internal fun MyExpThisYearCard(
    currentYearExp: Int,
    expectLevel: String,
    modifier: Modifier = Modifier,
) {
    HandsUpShadowCard(
        elevationSize = 4.dp,
        offsetY = 2.dp,
        shadowColor = CardShadowLight,
        content = {
            Column(
                modifier = modifier.fillMaxWidth().padding(Dimens.margin20),
            ) {
                Text(
                    text = stringResource(R.string.exp_this_year_title),
                    style = HandsUpTypography.title5,
                )
                Spacer(modifier = modifier.height(Dimens.margin16))
                Row {
                    ExpCircularGraph(currentYearExp = currentYearExp)
                    Spacer(modifier = modifier.width(Dimens.margin12))
                    Column {
                        ThisYearExpCard(exp = currentYearExp)
                        Spacer(modifier = modifier.height(Dimens.margin6))
                        ExpectLevelCard(expectLevel = expectLevel)
                    }
                }
            }
        }
    )
}

@Composable
private fun ThisYearExpCard(
    exp: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .background(
                color = Backgroud,
                shape = RoundedCornerShape(Dimens.cornerShape8),
            ).padding(
                vertical = Dimens.margin11,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "$exp",
                style = HandsUpTypography.title4.copy(
                    fontWeight = FontWeight.ExtraBold,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin2))
            Image(
                modifier = modifier.size(18.dp),
                imageVector = Icons.Dodoong,
                contentDescription = null,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = stringResource(R.string.exp_this_year_sub_title1),
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Medium,
            )
        )
    }
}

@Composable
private fun ExpectLevelCard(
    expectLevel: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .background(
                color = Backgroud,
                shape = RoundedCornerShape(Dimens.cornerShape8),
            ).padding(
                vertical = Dimens.margin11,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = expectLevel,
                style = HandsUpTypography.title4.copy(
                    fontWeight = FontWeight.ExtraBold,
                )
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin4))
        Text(
            text = stringResource(R.string.exp_this_year_sub_title2),
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Medium,
            )
        )
    }
}

@Preview(name = "MyExpThisYearCard")
@Composable
private fun PreviewMyExpThisYearCard() {
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        MyExpThisYearCard(6000,"B1")
    }
}