package com.tenday.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray450
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.home.R

private val blackFilter = ColorFilter.colorMatrix(
    ColorMatrix().apply { setToSaturation(0f) }
)
@Composable
internal fun HomeExpEmptyView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Gray100,
                shape = RoundedCornerShape(Dimens.cornerShape8)
            )
            .padding(vertical = Dimens.margin24),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.size(40.dp),
            imageVector = Icons.Dodoong,
            contentDescription = null,
            colorFilter = blackFilter ,
        )
        Spacer(modifier = modifier.height(Dimens.margin8))
        Text(
            text = stringResource(R.string.home_empty_exp_title),
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray450,
        )
        Text(
            text = stringResource(R.string.home_empty_exp_desc),
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            color = Gray450,
        )
    }
}

@Preview(name = "HomeExpEmptyView")
@Composable
private fun PreviewHomeEmptyExpView() {
    HomeExpEmptyView()
}