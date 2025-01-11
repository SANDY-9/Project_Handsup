package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.extensions.ProfileCode
import com.tenday.designsystem.R

@Composable
internal fun ProfileImage(
    profileCode: ProfileCode,
    modifier: Modifier = Modifier,
) {
    val resId = remember {
        when(profileCode) {
            ProfileCode.B_A -> R.drawable.test
            else -> 3
        }
    }
    Image(
        modifier = modifier,
        painter = painterResource(resId),
        contentDescription = null,
    )
}

@Preview(name = "ProfileImage")
@Composable
private fun PreviewProfileImage() {
    ProfileImage(ProfileCode.B_A)
}