package com.tenday.feature.exp.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.components.LinearExpGraph
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.HandsUpNavy
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@Composable
internal fun MyExpLinearGraph(
    currentValue: Int,
    maxValue: Int = 27000,
    modifier: Modifier = Modifier,
) {
    var currentExp  by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        currentExp  = currentValue // 예시: 목표 값으로 설정
    }
    val animatedValue by animateIntAsState(
        targetValue = currentExp,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LinearExpGraph(
            currentValue = currentValue,
            maxValue = maxValue
        )
        Spacer(modifier = modifier.height(Dimens.margin4))
        Row {
            Text(
                text = stringResource(R.string.exp_linear_graph_exp_title),
                style = HandsUpTypography.body3.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                )
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "${animatedValue.toData()}/${maxValue.toData()}",
                style = HandsUpTypography.body3.copy(
                    fontWeight = FontWeight.Medium,
                    color = White,
                )
            )
        }
    }
}

@Preview(name = "MyExpLinearGraph")
@Composable
private fun PreviewMyExpLinearGraph() {
    Box(
        modifier = Modifier
            .background(color = HandsUpNavy)
            .padding(20.dp),
    ) {
        MyExpLinearGraph(14000)
    }
}