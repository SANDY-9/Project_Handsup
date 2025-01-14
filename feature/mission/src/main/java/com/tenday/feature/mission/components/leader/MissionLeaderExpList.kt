package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.MissionDetails.Companion.getWeeklyExpList
import com.tenday.core.model.MissionExp
import com.tenday.designsystem.components.missionCard.MonthlyMissionCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.mission.MissionMenu
import com.tenday.feature.mission.components.MissionExpTitle
import com.tenday.feature.mission.components.MissionWeeklyCard
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionLeaderExpList(
    period: MissionPeriod,
    expList: List<MissionExp>,
    totalExp: Int,
    onFullScroll: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    year: Int = 2025,
) {
    val lazyColumnState = rememberLazyListState()
    LaunchedEffect(lazyColumnState) {
        snapshotFlow { lazyColumnState.firstVisibleItemScrollOffset }.collectLatest { offset ->
            // 스크롤 오프셋에 따라 크기 변경
            val isFullScroll = offset <= 0
            onFullScroll(isFullScroll)
        }
    }
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin24,
            top = 0.dp
        ),
        state = lazyColumnState,
    ) {
        stickyHeader {
            MissionExpTitle(
                title = MissionMenu.리더부여.name,
                exp = totalExp
            )
        }
        when(period) {
            MissionPeriod.WEEK -> {
                item {
                    val data by remember(expList) {
                        mutableStateOf(expList.getWeeklyExpList())
                    }
                    data.forEach { (month, list) ->
                        Column {
                            MissionWeeklyCard(
                                month = month,
                                expList = list,
                            )
                            Spacer(modifier = modifier.height(Dimens.margin12))
                        }
                    }
                }
            }
            else -> {
                item {
                    MonthlyMissionCard(
                        year = year,
                        achieve = expList.map { it.achieveGrade },
                    )
                }
            }
        }
    }
}

@Preview(name = "MissionLeaderExpList")
@Composable
private fun PreviewMissionLeaderExpList() {
    MissionLeaderExpList(
        period = MissionPeriod.WEEK,
        expList = listOf(
            MissionExp(
                achieveGrade = AchieveGrade.MAX,
                exp = 30,
                index = 3,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
            MissionExp(
                achieveGrade = AchieveGrade.MEDIAN,
                exp = 30,
                index = 4,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
            MissionExp(
                achieveGrade = AchieveGrade.NULL,
                exp = 30,
                index = 5,
                startDate = "01.01",
                endDate = "01.02",
                month = 2,
            ),
        ),
        totalExp = 5000,
        onFullScroll = {},
    )
}