package com.tenday.feature.exp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.components.LevelGraph
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray700
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.exp.R

@Composable
internal fun MyExpLastYearCard(
    modifier: Modifier = Modifier
) {
    HandsUpShadowCard(
        elevationSize = 4.dp,
        offsetY = 2.dp,
        shadowColor = CardShadowLight,
        content = {
            Column(
                modifier = modifier.padding(Dimens.margin20)
            ) {
                Text(
                    text = stringResource(R.string.exp_last_year_title),
                    style = HandsUpTypography.title5,
                )
                Spacer(modifier = modifier.height(Dimens.margin4))
                Text(
                    text = stringResource(R.string.exp_last_year_desc),
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Medium,
                        color = Gray700,
                    )
                )
                Spacer(modifier = modifier.height(Dimens.margin12))
                LevelGraph(13000)
                Spacer(modifier = modifier.height(Dimens.margin8))
                Row {
                    Text(
                        modifier = modifier
                            .background(
                                color = Gray100,
                                shape = RoundedCornerShape(Dimens.cornerShape4),
                            )
                            .padding(
                                vertical = Dimens.margin2,
                                horizontal = Dimens.margin6,
                            ),
                        text = "F1-II",
                        style = HandsUpTypography.body3.copy(
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Spacer(modifier = modifier.weight(1f))
                    Text(
                        modifier = modifier
                            .background(
                                color = Gray100,
                                shape = RoundedCornerShape(Dimens.cornerShape4),
                            )
                            .padding(
                                vertical = Dimens.margin2,
                                horizontal = Dimens.margin6,
                            ),
                        text = "F1-III",
                        style = HandsUpTypography.body3.copy(
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }
        }
    )
}

@Preview(name = "MyExpLastYearCard")
@Composable
private fun PreviewMyExpLastYearCard() {
    MyExpLastYearCard()
}