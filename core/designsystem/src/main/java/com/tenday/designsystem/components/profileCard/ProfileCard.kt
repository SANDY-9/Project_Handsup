package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.R
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.dashedFill
import com.tenday.designsystem.icons.HandsUpLogo
import com.tenday.designsystem.theme.Gray300

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(390.dp)
    ) {
        ProfileFrameField()
        Column(
            modifier = modifier.padding(
                top = Dimens.margin32,
                start = Dimens.margin32,
                end = Dimens.margin32,
                bottom = Dimens.margin32,
            )
        ) {
            ProfileCardHeader()
            Spacer(modifier = modifier.height(Dimens.margin6))
            Image(
                modifier = modifier.size(100.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.test),
                contentDescription = null,
            )
            Spacer(modifier = modifier.height(Dimens.margin10))
            ProfileCardName(modifier = modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = modifier.height(Dimens.margin6))
            ProfileCardInfo(modifier = modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = modifier.height(Dimens.margin16))
            Box(
                modifier = modifier.fillMaxWidth()
                    .height(2.dp)
                    .padding(horizontal = Dimens.margin12)
                    .dashedFill(
                        color = Gray300,
                    )
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
            ProfileCardLevel()
            Spacer(modifier = modifier.weight(1f))
            Icon(
                modifier = modifier.align(Alignment.CenterHorizontally)
                    .alpha(0.2f).height(20.dp),
                imageVector = Icons.HandsUpLogo,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun ProfileFrameField(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.profile_frame_field_01),
            contentDescription = null,
        )
        Image(
            modifier = modifier.weight(1f),
            painter = painterResource(R.drawable.profile_frame_field_02),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            painter = painterResource(R.drawable.profile_frame_field_03),
            contentDescription = null,
        )
    }
}


@Preview(name = "ProfileCard")
@Composable
private fun PreviewProfileCard() {
    ProfileCard()
}