package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.missionCard.MonthlyMissionCard
import com.tenday.designsystem.components.missionCard.WeeklyMissionCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionExpTitle
import com.tenday.feature.mission.components.MissionToolTip
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionLeaderView(
    jobFamily: String,
    jobGroup: Int,
    modifier: Modifier = Modifier
) {
    var type by remember { mutableStateOf("업무개선") }
    var visibleTable by rememberSaveable { mutableStateOf(true) }
    var visibleImproveToolTip by rememberSaveable { mutableStateOf(false) }
    var visibleSpecialToolTip by rememberSaveable { mutableStateOf(false) }
    val pagerState = rememberPagerState (
        pageCount = { 2 }
    )
    val lazyColumnState = rememberLazyListState()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            type = if(page == 0) "업무개선" else "월특근"
        }
    }
    LaunchedEffect(lazyColumnState) {
        snapshotFlow { lazyColumnState.firstVisibleItemScrollOffset }.collectLatest { offset ->
            // 스크롤 오프셋에 따라 크기 변경
            visibleTable = offset <= 0
            visibleImproveToolTip = false
            visibleSpecialToolTip = false
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    visibleImproveToolTip = false
                    visibleSpecialToolTip = false
                }
            },
    ) {
        Box {
            HorizontalPager(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = White),
                state = pagerState,
                pageSize = PageSize.Fixed(300.dp),
                pageSpacing = Dimens.margin8,
                contentPadding = PaddingValues(
                    start = Dimens.margin20,
                    end = Dimens.margin20,
                    bottom = Dimens.margin16
                )
            ) { page ->
                when(page) {
                    0 -> ImproveWorkMissionCard(
                        jobFamily = jobFamily,
                        jobGroup = jobGroup,
                        visibleTable = visibleTable,
                        onShowImproveToolTip = { visibleImproveToolTip = true },
                    )
                    else -> SpecialWorkMissionCard(
                        jobFamily = jobFamily,
                        jobGroup = jobGroup,
                        visibleTable = visibleTable,
                        onShowTooltip = { visibleSpecialToolTip = true }
                    )
                }
            }
            //업무개선 툴팁
            if(visibleImproveToolTip) {
                MissionToolTip(
                    parentModifier = modifier.absoluteOffset(
                        x = 122.dp,
                        y = 42.dp,
                    ),
                    missionName = "업무 개선",
                )
            }
            //월특근 툴팁
            if(visibleSpecialToolTip) {
                MissionToolTip(
                    parentModifier = modifier.absoluteOffset(
                        x = 175.dp,
                        y = 42.dp,
                    ),
                    missionName = "업무 개선",
                )
            }
        }
        LazyColumn(
            modifier = modifier.fillMaxSize(),
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
                    WeeklyMissionCard()
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
}

@Preview(name = "MissionLeaderView")
@Composable
private fun PreviewMissionLeaderView() {
    Box {
        MissionLeaderView("음성 1센터", 1,)
    }
}