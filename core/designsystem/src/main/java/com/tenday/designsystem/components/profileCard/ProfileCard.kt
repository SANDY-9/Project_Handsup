package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.ProfileCode
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
    maxExp: Int,
    onNavigateSettings: () -> Unit,
    parentModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = parentModifier
            .fillMaxWidth()
            .heightIn(
                min = 376.dp,
                max = 400.dp,
            )
    ) {
        ProfileCardFrame(
            jobFamily = jobFamily,
        )
        Column(
            modifier = modifier.padding(
                top = Dimens.margin32,
                start = Dimens.margin33,
                end = Dimens.margin31,
                bottom = Dimens.margin32,
            )
        ) {
            ProfileCardHeader(
                hireDate = hireDate,
                onNavigateSettings = onNavigateSettings,
            )
            Spacer(modifier = modifier.height(Dimens.margin12))
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
                maxExp = maxExp,
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
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
     ProfileCard(
         department = "음성 1센터",
         employeeId = "2023010101",
         hireDate = "2023-01-01",
         jobFamily = JobFamily.F,
         jobPosition = "파트장",
         jobLevel = "F1-Ⅰ",
         profileBadgeCode = BadgeCode.NULL,
         profileImageCode = ProfileCode.F_A,
         totalExpLastYear = 5000,
         username = "",
         maxExp = 27500,
         onNavigateSettings = {  }
     )
}