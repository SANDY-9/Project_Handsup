package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.HandsUpBlack
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpOrangeSub
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun ProfileCardInfo(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        BelongsBadge()
        Spacer(modifier = modifier.width(Dimens.margin6))
        EmployeeNumberBadge()
    }
}

@Composable
private fun BelongsBadge(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.background(
            color = HandsUpOrangeSub,
            shape = RoundedCornerShape(Dimens.cornerShape4)
        ).padding(
            vertical = Dimens.margin2,
            horizontal = Dimens.margin6,
        ),
        text = "남양주센터·현장직군",
        style = HandsUpTypography.body3.copy(
            fontWeight = FontWeight.Bold,
            color = HandsUpOrange,
        )
    )
}

@Composable
private fun EmployeeNumberBadge(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.background(
            color = Gray100,
            shape = RoundedCornerShape(Dimens.cornerShape4)
        ).padding(
            vertical = Dimens.margin2,
            horizontal = Dimens.margin6,
        ),
        text = "2024122050",
        style = HandsUpTypography.body3.copy(
            fontWeight = FontWeight.Bold,
            color = HandsUpBlack,
        )
    )
}

@Preview(name = "ProfileCardInfo")
@Composable
private fun PreviewProfileCardInfo() {
    ProfileCardInfo()
}