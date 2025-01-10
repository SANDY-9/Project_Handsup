package com.tenday.designsystem.components.profileCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.R
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun ProfileCardName(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "김민수 파트장",
            style = HandsUpTypography.title2,
        )
        Spacer(modifier = modifier.width(Dimens.margin4))
        Image(
            modifier = modifier.size(20.dp),
            painter = painterResource(R.drawable.badge),
            contentDescription = null,
        )
    }
}

@Preview(name = "ProfileCardName")
@Composable
private fun PreviewProfileCardName() {
    ProfileCardName()
}