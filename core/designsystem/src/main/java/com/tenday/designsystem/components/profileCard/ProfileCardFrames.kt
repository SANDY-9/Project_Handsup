package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.JobFamily
import com.tenday.designsystem.R

@Composable
internal fun ProfileCardFrame(
    jobFamily: JobFamily,
) {
    when(jobFamily) {
        JobFamily.F -> ProfileFrameField()
        JobFamily.B -> ProfileFrameManage()
        JobFamily.G -> ProfileFrameCx()
        JobFamily.T -> ProfileFrameTech()
        else -> Unit
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
            modifier = modifier.weight(1f).offset(x = (-1).dp),
            painter = painterResource(R.drawable.profile_frame_field_02),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            modifier = modifier.offset(x = (-2).dp),
            painter = painterResource(R.drawable.profile_frame_field_03),
            contentDescription = null,
        )
    }
}

@Composable
private fun ProfileFrameManage(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.profile_frame_manage_01),
            contentDescription = null,
        )
        Image(
            modifier = modifier.weight(1f).offset(x = (-1).dp),
            painter = painterResource(R.drawable.profile_frame_manage_02),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            modifier = modifier.offset(x = (-2).dp),
            painter = painterResource(R.drawable.profile_frame_manage_03),
            contentDescription = null,
        )
    }
}

@Composable
private fun ProfileFrameCx(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.profile_frame_cx_01),
            contentDescription = null,
        )
        Image(
            modifier = modifier.weight(1f).offset(x = (-1).dp),
            painter = painterResource(R.drawable.profile_frame_cx_02),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            modifier = modifier.offset(x = (-2).dp),
            painter = painterResource(R.drawable.profile_frame_cx_03),
            contentDescription = null,
        )
    }
}

@Composable
private fun ProfileFrameTech(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.profile_frame_tech_01),
            contentDescription = null,
        )
        Image(
            modifier = modifier.weight(1f).offset(x = (-1).dp),
            painter = painterResource(R.drawable.profile_frame_tech_02),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            modifier = modifier.offset(x = (-2).dp),
            painter = painterResource(R.drawable.profile_frame_tech_03),
            contentDescription = null,
        )
    }
}