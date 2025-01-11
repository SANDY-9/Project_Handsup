package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.enums.ProfileCode
import com.tenday.designsystem.R

@Composable
internal fun ProfileImage(
    profileCode: ProfileCode,
    modifier: Modifier = Modifier,
) {
    val resId = remember {
        when(profileCode) {
            ProfileCode.F_A -> R.drawable.profile_img_fa
            ProfileCode.F_B -> R.drawable.profile_img_fb
            ProfileCode.B_A -> R.drawable.profile_img_ba
            ProfileCode.B_B -> R.drawable.profile_img_fb
            ProfileCode.G_A -> R.drawable.profile_img_ga
            ProfileCode.G_B -> R.drawable.profile_img_ga
            ProfileCode.T_A -> R.drawable.profile_img_ta
            ProfileCode.T_B -> R.drawable.profile_img_tb
            else -> R.drawable.profile_img_fb
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