package com.tenday.feature.mission.components.job

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.missionCard.WeeklyMissionCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionExpTitle
import com.tenday.feature.mission.components.MissionToolTop
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionJobView(
    jobFamily: String,
    jobGroup: Int,
    modifier: Modifier = Modifier,
) {
    var visibleTable by rememberSaveable { mutableStateOf(true) }
    var visibleToolTip by rememberSaveable { mutableStateOf(false) }
    val lazyColumnState = rememberLazyListState()
    LaunchedEffect(lazyColumnState) {
        snapshotFlow { lazyColumnState.firstVisibleItemScrollOffset }.collectLatest { offset ->
            // 스크롤 오프셋에 따라 크기 변경
            visibleTable = offset <= 0
            visibleToolTip = false
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    visibleToolTip = false
                }
            }
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = White),
        ) {
            Box(
                modifier = modifier.padding(
                    start = Dimens.margin20,
                    end = Dimens.margin20,
                    bottom = Dimens.margin16,
                )
            ) {
                JobMissionCard(
                    jobFamily = jobFamily,
                    jobGroup = jobGroup,
                    visibleTable = visibleTable,
                    onShowTooltip = { visibleToolTip = true },
                )
            }
            if(visibleToolTip) {
                MissionToolTop(
                    parentModifier = modifier
                        .absoluteOffset(y = 42.dp,)
                        .align(Alignment.TopEnd)
                        .padding(end = Dimens.margin6),
                    missionName = "생산성향상",
                    onToolTipClick = {},
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
                    type = stringResource(R.string.mission_job_title)
                )
            }
            items(5) {
                WeeklyMissionCard()
                Spacer(modifier = modifier.height(Dimens.margin12))
            }
        }
    }
}

@Preview(name = "MissionJobView")
@Composable
private fun PreviewMissionJobView() {
    MissionJobView("음성 1센터", 1)
}