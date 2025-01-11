package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.HandsUp
import com.tenday.designsystem.icons.Settings
import com.tenday.designsystem.theme.Gray400
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun ProfileCardHeader(
    hireDate: String,
    onNavigateSettings: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = modifier
                .clip(CircleShape)
                .size(20.dp),
            imageVector = Icons.HandsUp,
            contentDescription = null,
        )
        Spacer(modifier = modifier.width(Dimens.margin4))
        Text(
            text = "입사일",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray600,
        )
        Text(
            text = "·",
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray600,
        )
        Text(
            text = hireDate,
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray600,
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(
            modifier = modifier
                .size(24.dp)
                .clickable(onClick = onNavigateSettings),
            imageVector = Icons.Settings,
            contentDescription = null,
            tint = Gray400,
        )
    }
}

@Preview(name = "ProfileCardHeader")
@Composable
private fun PreviewProfileCardHeader() {
    ProfileCardHeader("2024.12.20", {})
}