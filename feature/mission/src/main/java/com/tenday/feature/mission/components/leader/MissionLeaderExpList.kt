package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.designsystem.components.missionCard.MonthlyMissionCard
import com.tenday.designsystem.components.missionCard.WeeklyMissionCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionExpTitle
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionLeaderExpList(
    type: String,
    onFullScroll: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
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
                type = stringResource(R.string.mission_leader_title)
            )
        }
        when(type) {
            "업무개선" -> items(5) {
                if(it == 1) {
                    WeeklyMissionCard(
                        it + 1,
                        listOf(6,7,8,9),
                        listOf( "02.02~02.05", "02.02~02.05", "02.02~02.05", "99.99~02.08",),
                        listOf(AchieveGrade.MIN, AchieveGrade.MAX)
                    )
                }
                else if(it == 0) {
                    WeeklyMissionCard(it + 1)
                }
                else {
                    WeeklyMissionCard(
                        it + 1,
                        listOf(10,11,12,13,14),
                        listOf( "02.02~02.05", "02.02~02.05", "02.02~02.05", "99.99~02.08", "02.02~02.05"),
                        listOf()
                    )
                }
                Spacer(modifier = modifier.height(Dimens.margin12))
            }
            else -> {
                item {
                    MonthlyMissionCard()
                }
            }
        }
    }
}

@Preview(name = "MissionLeaderExpList")
@Composable
private fun PreviewMissionLeaderExpList() {
    MissionLeaderExpList("업무개선", {})
}