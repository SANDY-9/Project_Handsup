package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.extensions.BadgeCode
import com.tenday.core.common.extensions.JobFamily
import com.tenday.core.common.extensions.ProfileCode
import com.tenday.designsystem.R
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.dashedFill
import com.tenday.designsystem.theme.Gray300

@Composable
fun ProfileCard(
    department: String,
    employeeId: String,
    hireDate: String,
    jobFamily: JobFamily,
    jobPosition: String,
    jobLevel: String,
    profileBadgeCode: BadgeCode,
    profileImageCode: ProfileCode,
    totalExpLastYear: Int,
    username: String,
    onNavigateSettings: () -> Unit,
    parentModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = parentModifier
            .fillMaxWidth()
            .height(390.dp)
    ) {
        ProfileCardFrame(
            jobFamily = jobFamily,
        )
        Column(
            modifier = modifier.padding(
                top = Dimens.margin32,
                start = Dimens.margin32,
                end = Dimens.margin32,
                bottom = Dimens.margin32,
            )
        ) {
            ProfileCardHeader(
                hireDate = hireDate,
                onNavigateSettings = onNavigateSettings,
            )
            Spacer(modifier = modifier.height(Dimens.margin6))
            ProfileImage(
                modifier = modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                profileCode = profileImageCode,
            )
            Spacer(modifier = modifier.height(Dimens.margin10))
            ProfileCardName(
                modifier = modifier.align(Alignment.CenterHorizontally),
                name = username,
                jobPosition = jobPosition,
                badgeCode = profileBadgeCode,
            )
            Spacer(modifier = modifier.height(Dimens.margin6))
            ProfileCardInfo(
                modifier = modifier.align(Alignment.CenterHorizontally),
                department = department,
                jobFamily = jobFamily.desc,
                employeeId = employeeId,
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .padding(horizontal = Dimens.margin12)
                    .dashedFill(color = Gray300)
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
            ProfileCardLevel(
                level = jobLevel,
                exp = totalExpLastYear,
            )
            Spacer(modifier = modifier.height(Dimens.margin8))
            Image(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .height(15.dp),
                painter = painterResource(R.drawable.logo_duhands),
                contentDescription = null,
            )
        }
    }
}


@Preview(name = "ProfileCard")
@Composable
private fun PreviewProfileCard() {
    // ProfileCard()
}