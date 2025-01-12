package com.tenday.feature.mission.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.components.HandsUpTabButton
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.MissionMenu

@Composable
internal fun MissionTitleBar(
    currentSelectedTab: MissionMenu,
    onTabSelect: (MissionMenu) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = White)
            .padding(horizontal = Dimens.margin20),
    ) {
        Spacer(modifier = modifier.systemBarsPadding())
        MissionTab(
            currentSelectedTab = currentSelectedTab,
            onTabSelect = onTabSelect,
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
    }

}
@Composable
private fun MissionTab(
    currentSelectedTab: MissionMenu,
    onTabSelect: (MissionMenu) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Gray100,
                shape = RoundedCornerShape(Dimens.margin12)
            )
            .padding(Dimens.margin8)
    ) {
        HandsUpTabButton(
            title = MissionMenu.리더부여.name,
            selected = MissionMenu.리더부여 == currentSelectedTab,
            onSelectClick = {},
            onUnselectClick = { onTabSelect(MissionMenu.리더부여) }
        )
        HandsUpTabButton(
            title = MissionMenu.직무미션.name,
            selected = MissionMenu.직무미션 == currentSelectedTab,
            onSelectClick = {},
            onUnselectClick = { onTabSelect(MissionMenu.직무미션) }

        )
        HandsUpTabButton(
            title = MissionMenu.전사프로젝트.name,
            selected = MissionMenu.전사프로젝트 == currentSelectedTab,
            onSelectClick = {},
            onUnselectClick = { onTabSelect(MissionMenu.전사프로젝트) }
        )
        HandsUpTabButton(
            title = MissionMenu.인사평가.name,
            selected = MissionMenu.인사평가 == currentSelectedTab,
            onSelectClick = {},
            onUnselectClick = { onTabSelect(MissionMenu.인사평가) }
        )
    }
}

@Preview(name = "MissionTab")
@Composable
private fun PreviewMissionTab() {
    var currentClickTab by remember { mutableStateOf(MissionMenu.리더부여) }
    MissionTitleBar(currentClickTab, { currentClickTab = it })
}