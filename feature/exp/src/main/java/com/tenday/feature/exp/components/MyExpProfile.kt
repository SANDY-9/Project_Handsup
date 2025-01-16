package com.tenday.feature.exp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.extentions.svgImageLoader
import com.tenday.designsystem.extentions.svgPath
import com.tenday.designsystem.icons.Info
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.LinearGradientNavy
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun MyExpProfile(
    user: UserDetails,
    currentTotalExp: Int,
    requireExp: Int,
    onLevelGuideClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(brush = LinearGradientNavy)
            .statusBarsPadding()
            .padding(
                start = Dimens.margin20,
                end = Dimens.margin20,
                bottom = Dimens.margin36,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = modifier.height(Dimens.margin16))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(R.string.exp_guide_title),
                style = HandsUpTypography.body4.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Icon(
                modifier = modifier.size(16.dp).noRippleClickable(
                    onClick = onLevelGuideClick
                ),
                imageVector = Icons.Info,
                contentDescription = null,
                tint = White,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin8))
        Image(
            modifier = modifier.size(100.dp),
            painter = svgImageLoader(user.jobLevel.svgPath()),
            contentDescription = null,
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.exp_desc_prefix, user.username),
                style = HandsUpTypography.body1.copy(
                    color = White,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Text(
                text = user.jobLevel,
                style = HandsUpTypography.body1.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                )
            )
            Spacer(modifier = modifier.width(Dimens.margin4))
            Text(
                text = stringResource(R.string.exp_desc_suffix),
                style = HandsUpTypography.title5.copy(
                    color = White,
                )
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin16))
        MyExpLinearGraph(
            currentValue = currentTotalExp,
            maxValue = currentTotalExp + requireExp,
        )
        Spacer(modifier = modifier.height(Dimens.margin20))
        MyRemainingExpCard(
            currentExp = currentTotalExp,
            requireExp = requireExp,
        )
    }
}

@Preview(name = "MyExpProfile")
@Composable
private fun PreviewMyExpProfile() {
    MyExpProfile(
        UserDetails(
            employeeId = "2023010101",
            username = "김민수",
            hireDate = "2023-01-01",
            department = "음성 1센터",
            jobPosition = JobPosition.파트장,
            jobGroup = 1,
            jobFamily = JobFamily.F,
            jobLevel = "F1-Ⅰ",
            totalExpLastYear = 5000,
            profileImageCode = ProfileCode.F_A,
            profileBadgeCode = BadgeCode.EXP_EVERY_MONTH_FOR_A_YEAR,
            possibleBadgeCodeList = emptyList()
        ),
        13000,
        27000,
        {}
    )
}