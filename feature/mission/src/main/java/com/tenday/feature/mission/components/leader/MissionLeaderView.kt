package com.tenday.feature.mission.components.leader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.missionCard.MonthlyMissionCard
import com.tenday.designsystem.components.missionCard.WeeklyMissionCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionExpTitle

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MissionLeaderView(
    jobFamily: String,
    jobGroup: Int,
    onShowTooltip: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState (
        pageCount = { 2 }
    )
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = modifier.fillMaxWidth().background(color = White),
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
                    onShowTooltip = onShowTooltip
                )
                else -> SpecialWorkMissionCard(
                    jobFamily = jobFamily,
                    jobGroup = jobGroup,
                    onShowTooltip = onShowTooltip
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
        ) {
            stickyHeader {
                MissionExpTitle(
                    type = stringResource(R.string.mission_leader_title)
                )
            }
            items(5) {
                WeeklyMissionCard()
                Spacer(modifier = modifier.height(Dimens.margin12))
            }
            item {
                MonthlyMissionCard()
            }
        }
    }
}

@Preview(name = "MissionLeaderView")
@Composable
private fun PreviewMissionLeaderView() {
    Box {
        MissionLeaderView("음성 1센터", 1, {})
    }
}