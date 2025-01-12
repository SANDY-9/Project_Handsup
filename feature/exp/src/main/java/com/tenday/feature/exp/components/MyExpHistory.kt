package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.ArrowBottom
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpOrangeSub
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.exp.R

@Composable
internal fun MyExpHistory(
    modifier: Modifier = Modifier,
) {
    HandsUpShadowCard(
        content = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(Dimens.margin20),
            ) {
                MyExpHistoryHeader()
                Spacer(modifier = modifier.height(Dimens.margin12))
                repeat(10) {
                    MyExpHistoryItem(
                        missionName = "직무미션",
                        expName = listOf("생산성 향상", "월특근", "업무 개선").random(),
                        date = "2025.02.02",
                        exp = (10..3000).random()
                    )
                }
            }
        }
    )
}

@Composable
private fun MyExpHistoryHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "2025년",
            style = HandsUpTypography.title4.copy(
                fontWeight = FontWeight.ExtraBold,
            )
        )
        Spacer(modifier = modifier.width(Dimens.margin4))
        Icon(
            modifier = modifier.size(16.dp),
            imageVector = Icons.ArrowBottom,
            contentDescription = null,
            tint = Gray900
        )
        Spacer(modifier = modifier.weight(1f))
        Row(
            modifier = modifier
                .background(
                    color = HandsUpOrangeSub,
                    shape = CircleShape,
                )
                .padding(
                    start = Dimens.margin16,
                    end = Dimens.margin12,
                    top = Dimens.margin6,
                    bottom = Dimens.margin6,
                )
                .clip(CircleShape)
                .clickable(onClick = {})
        ) {
            Text(
                text = stringResource(R.string.exp_history_sort_all),
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = HandsUpOrange,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin8))
            Icon(
                modifier = modifier.size(16.dp),
                imageVector = Icons.ArrowBottom,
                contentDescription = null,
                tint = HandsUpOrange,
            )
        }
    }
}

@Composable
private fun MyExpHistoryItem(
    missionName: String,
    expName: String,
    date: String,
    exp: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) { 
        HorizontalDivider(color = Gray100)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = Dimens.margin12
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = expName,
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = modifier.height(Dimens.margin4))
                Text(
                    text = "$missionName·$date",
                    style = HandsUpTypography.body3.copy(
                        fontWeight = FontWeight.Medium,
                        color = Gray600,
                    )
                )
            }
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = exp.toData(),
                style = HandsUpTypography.title5.copy(
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
    }
}

@Preview(name = "MyExpHistory")
@Composable
private fun PreviewMyExpHistory() {
    MyExpHistory()
}