package com.tenday.feature.mission.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.mission.R

@Composable
internal fun MissionExpTitle(
    title: String,
    exp: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Gray100,
            )
            .padding(
                top = Dimens.margin20,
                bottom = Dimens.margin16,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$title"+ stringResource(R.string.mission_exp_title),
            style = HandsUpTypography.title5.copy(
                fontWeight = FontWeight.ExtraBold,
            )
        )
        Spacer(modifier = modifier.width(Dimens.margin8))
        Text(
            text = exp.toString(),
            style = HandsUpTypography.title5.copy(
                fontWeight = FontWeight.ExtraBold,
                color = HandsUpOrange,
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

@Preview(name = "MissionExpTitle")
@Composable
private fun PreviewMissionExpTitle() {
    MissionExpTitle("리더부여", 4000)
}