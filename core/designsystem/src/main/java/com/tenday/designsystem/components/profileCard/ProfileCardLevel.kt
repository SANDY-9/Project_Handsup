package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun ProfileCardLevel(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LevelBadge()
        Spacer(modifier = modifier.height(Dimens.margin4))
        Canvas(modifier) { }
        Spacer(modifier = modifier.height(20.dp))
        LevelDesc()
    }
}

@Composable
private fun LevelBadge(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.background(
            color = Gray100,
            shape = RoundedCornerShape(Dimens.cornerShape4)
        ).padding(
            vertical = Dimens.margin2,
            horizontal = Dimens.margin6,
        )
    ) {
        Text(
            text = "LV. ",
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
        Text(
            text = "F2-II",
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Composable
private fun LevelDesc(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            text = "다음 레벨까지 ",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.Bold,
            )
        )
        Text(
            text = "13,500do",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.Bold,
            ),
            color = HandsUpOrange,
        )
        Text(
            text = " 남았어요!",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.Bold,
            )
        )
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "14,000/27,500",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray500
        )
    }
}

@Preview(name = "ProfileCardLevel")
@Composable
private fun PreviewProfileCardLevel() {
    ProfileCardLevel()
}