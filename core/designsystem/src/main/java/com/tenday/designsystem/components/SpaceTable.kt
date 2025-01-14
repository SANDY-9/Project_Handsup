package com.tenday.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Up
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.Positive
import com.tenday.designsystem.theme.TransparentWhite8
import com.tenday.designsystem.theme.TransparentWhite80
import com.tenday.designsystem.theme.White

@Composable
fun HandsUpThreeSpaceTable(
    title1: String,
    content1: String,
    title2: String,
    content2: String,
    title3: String,
    content3: String,
    diff: Int? = null,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(
                color = TransparentWhite8,
                shape = RoundedCornerShape(Dimens.cornerShape8)
            )
            .height(IntrinsicSize.Max)
            .padding(Dimens.margin12)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title1,
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = TransparentWhite80,
            )
            Spacer(modifier = modifier.height(Dimens.margin4))
            Text(
                text = content1,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = White,
            )
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
                text = title2,
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = TransparentWhite80,
            )
            Spacer(modifier = modifier.height(Dimens.margin4))
            Text(
                text = content2,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = White,
            )
        }
        VerticalDivider(
            modifier = Modifier.padding(horizontal = 8.dp),
            color = TransparentWhite8,
        )
        Column (
            modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title3,
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
                    text = content3,
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
                    color = White,
                )
                diff?.let {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Up,
                        contentDescription = null,
                        tint = Positive,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    Box(
        modifier = Modifier.background(color = Color.Gray).padding(16.dp)
    ) {
        HandsUpThreeSpaceTable(
            "제목1", "내용1", "제목1", "내용1", "제목1", "내용1",
            modifier = Modifier.width(300.dp),
        )
    }
}