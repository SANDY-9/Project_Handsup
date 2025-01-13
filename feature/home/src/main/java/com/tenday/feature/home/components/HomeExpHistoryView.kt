package com.tenday.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenday.core.common.enums.ExpType
import com.tenday.core.common.extentions.toData
import com.tenday.core.model.Exp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun HomeExpHistoryView(
    expList: List<Exp>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = Dimens.margin20),
        horizontalArrangement = Arrangement.spacedBy(Dimens.margin8)
    ) {
        items(expList) { exp ->
            ExpHistoryItem(exp)
        }
        item {
            HomeExpBanner()
        }
    }
}

@Composable
private fun ExpHistoryItem(
    exp: Exp,
    modifier: Modifier = Modifier,
) {
    HandsUpShadowCard(
        cornerSize = Dimens.cornerShape8,
        content = {
            Column(
                modifier = modifier.size(
                    width = 114.dp,
                    height = 129.dp,
                ).padding(
                    horizontal = Dimens.margin12,
                    vertical = Dimens.margin16,
                )
            ) {
                Text(
                    text = exp.expType.quest,
                    style = HandsUpTypography.body4.copy(
                        fontSize = 10.sp
                    ),
                    color = Gray600,
                )
                Spacer(modifier = modifier.height(Dimens.margin2))
                Text(
                    text = exp.questName,
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.height(Dimens.margin6))
                Text(
                    text = exp.expAt,
                    style = HandsUpTypography.body2.copy(
                        fontSize = 10.sp
                    ),
                    color = Gray500,
                )
                Spacer(modifier = modifier.weight(1f))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                ) {
                    Text(
                        text = exp.exp.toData(),
                        style = HandsUpTypography.title5.copy(
                            fontWeight = FontWeight.ExtraBold,
                        ),
                        color = HandsUpOrange,
                    )
                    Spacer(modifier = modifier.width(Dimens.margin2))
                    Image(
                        modifier = modifier.size(18.dp),
                        imageVector = Icons.Dodoong,
                        contentDescription = null,
                    )
                }
            }
        }
    )
}

@Preview(name = "HomeExpHistoryView")
@Composable
private fun PreviewHomeExpHistoryView() {
    HomeExpHistoryView(
        listOf(
            Exp(
                exp = 50,
                expAt = "2025.02.13",
                expType = ExpType.C,
                questName = "월특근",
                year = 2025
            )
        )
    )
}