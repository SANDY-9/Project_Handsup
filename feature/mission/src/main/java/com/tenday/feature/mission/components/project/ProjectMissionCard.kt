package com.tenday.feature.mission.components.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.Dodoong
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.mission.R

@Composable
internal fun ProjectMissionCard(
    modifier: Modifier = Modifier
) {
    HandsUpShadowCard(
        offsetY = 2.dp,
        elevationSize = 4.dp,
        shadowColor = CardShadowLight,
        content = {
            Column(
                modifier = modifier.padding(Dimens.margin20),
            ) {
                Text(
                    text = "01.02 - 01.05",
                    style = HandsUpTypography.body4.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = HandsUpOrange,
                    )
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "환불 프로세스 최적화",
                    style = HandsUpTypography.title5,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.height(6.dp))
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "환불 절차를 간소화하고 고객의 불편을 " +
                            "최소화 할 수있는 정책 개선 및 운영 비용 절감 프로젝트",
                    style = HandsUpTypography.body2,
                    color = Gray600,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.height(20.dp))
                ProjectMissionExp()
            }
        }
    )
}

@Composable
private fun ProjectMissionExp(
    modifier: Modifier = Modifier,
) {
    Row {
        Text(
            modifier = modifier.background(
                color = Gray100,
                shape = RoundedCornerShape(Dimens.cornerShape4),
            ).padding(
                vertical = Dimens.margin4,
                horizontal = Dimens.margin6,
            ),
            text = "2025.01.11 " + stringResource(R.string.mission_project_exp_desc),
            style = HandsUpTypography.body4.copy(
                fontWeight = FontWeight.SemiBold,
            )
        )
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "2440",
            style = HandsUpTypography.title5.copy(
                fontWeight = FontWeight.ExtraBold,
                color = HandsUpOrange,
            )
        )
        Spacer(modifier = modifier.width(Dimens.margin2))
        Image(
            modifier = modifier.size(18.dp),
            imageVector = Icons.Dodoong,
            contentDescription = null,
        )
    }
}

@Preview(name = "ProjectMissionCard")
@Composable
private fun PreviewProjectMissionCard() {
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        ProjectMissionCard()
    }
}