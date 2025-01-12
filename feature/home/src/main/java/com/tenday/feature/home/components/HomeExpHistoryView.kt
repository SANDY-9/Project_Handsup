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
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun HomeExpHistoryView(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = Dimens.margin20),
        horizontalArrangement = Arrangement.spacedBy(Dimens.margin8)
    ) {
        items(5) {
            ExpHistoryItem()
        }
    }
}

@Composable
private fun ExpHistoryItem(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.width(114.dp)
    ) {
        HandsUpShadowCard(
            cornerSize = Dimens.cornerShape8,
            content = {
                Column(
                    modifier = modifier.padding(
                        horizontal = Dimens.margin12,
                        vertical = Dimens.margin16,
                    )
                ) {
                    Text(
                        text = "직무미션",
                        style = HandsUpTypography.body4,
                        color = Gray600,
                    )
                    Spacer(modifier = modifier.height(Dimens.margin2))
                    Text(
                        text = "생산성 향상",
                        style = HandsUpTypography.title5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = modifier.height(Dimens.margin4))
                    Text(
                        text = "2025.01.03",
                        style = HandsUpTypography.body2.copy(
                            fontSize = 10.sp
                        ),
                        color = Gray600,
                    )
                    Spacer(modifier = modifier.height(Dimens.margin16))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            text = "500",
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
}

@Preview(name = "HomeExpHistoryView")
@Composable
private fun PreviewHomeExpHistoryView() {
    HomeExpHistoryView()
}