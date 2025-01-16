package com.tenday.designsystem.components.profileCard

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.extentions.toData
import com.tenday.designsystem.components.LevelGraph
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
internal fun ProfileCardLevel(
    level: String,
    exp: Int,
    maxExp: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LevelBadge(level)
        Spacer(modifier = modifier.height(Dimens.margin4))
        LevelGraph(exp, maxExp)
        Spacer(modifier = modifier.height(Dimens.margin4))
        LevelDesc(exp, maxExp)
    }
}

@Composable
private fun LevelBadge(
    level: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.background(
            color = Gray100,
            shape = RoundedCornerShape(Dimens.cornerShape4)
        ).padding(
            vertical = Dimens.margin2,
            horizontal = Dimens.margin6,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "LV. ",
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
        Text(
            text = level,
            style = HandsUpTypography.body3.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Composable
private fun LevelDesc(
    exp: Int,
    maxValue: Int,
    modifier: Modifier = Modifier,
) {
    var currentExp  by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        currentExp  = exp // 예시: 목표 값으로 설정
    }
    val animatedValue by animateIntAsState(
        targetValue = currentExp,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )
    val remainExp = remember { maxValue - exp }
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
            text = "${remainExp.toData()}do",
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
            text = "${animatedValue.toData()}/${maxValue.toData()}",
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
    ProfileCardLevel("F2-II", 14000, 27500)
}