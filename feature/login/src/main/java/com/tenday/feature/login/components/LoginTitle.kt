package com.tenday.feature.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpTitleTopBar
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.login.R

@Composable
internal fun LoginTitle(
    modifier: Modifier = Modifier
) {
    HandsUpTitleTopBar(
       content = {
           Row(
               verticalAlignment = Alignment.CenterVertically,
           ) {
               Text(
                   text = stringResource(R.string.login_title_name),
                   style = HandsUpTypography.title4.copy(
                       fontWeight = FontWeight.ExtraBold,
                   ),
                   color = HandsUpOrange
               )
               Spacer(modifier = modifier.width(Dimens.margin2))
               Text(
                   text = stringResource(R.string.login_title),
                   style = HandsUpTypography.title4,
               )
           }
       }
    )
}

@Preview(name = "LoginTitle")
@Composable
private fun PreviewLoginTitle() {
    LoginTitle()
}