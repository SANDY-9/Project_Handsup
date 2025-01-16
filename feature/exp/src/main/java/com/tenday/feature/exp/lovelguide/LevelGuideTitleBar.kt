package com.tenday.feature.exp.lovelguide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpTitleTopBar
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.icons.Cancel
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun LevelGuideTitleBar(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(White)
    ) {
        HandsUpTitleTopBar(
            content = {
                Text(
                    text = stringResource(R.string.exp_level_guide),
                    style = HandsUpTypography.title4,
                )
                Icon(
                    modifier = modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd)
                        .clip(CircleShape)
                        .noRippleClickable(onClick = onClose),
                    imageVector = Icons.Cancel,
                    contentDescription = null,
                )
            }
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Row(
            modifier = modifier.padding(horizontal = Dimens.margin20)
        ) {
            Text(
                modifier = modifier
                    .fillMaxWidth(0.3f)
                    .background(
                        color = Gray100,
                        shape = RoundedCornerShape(Dimens.cornerShape8),
                    )
                    .padding(Dimens.margin6),
                text = stringResource(R.string.exp_level_colum),
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.width(Dimens.margin6))
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = Gray100,
                        shape = RoundedCornerShape(Dimens.cornerShape8),
                    )
                    .padding(Dimens.margin6),
                text = stringResource(R.string.exp_level_guide),
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = modifier.height(Dimens.margin12))
    }
}

@Preview(name = "BadgeGuideTitleBar")
@Composable
private fun PreviewBadgeGuideTitleBar() {
    LevelGuideTitleBar(
        {}
    )
}