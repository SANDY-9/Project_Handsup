
package com.tenday.feature.mission.components.leader

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.tenday.core.model.MissionDetails
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
internal fun MissionLeaderCardPager(
    department: String,
    jobGroup: Int,
    item: List<MissionDetails>,
    visibleTable: Boolean,
    onPageChange: (Int) -> Unit,
    onPagerSwipe: () -> Unit,
    onShowToolTip: (IntOffset) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState (pageCount = { item.size })
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            onPageChange(page)
        }
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPageOffsetFraction }.collectLatest {
            onPagerSwipe()
        }
    }
    val scope = rememberCoroutineScope()
    HorizontalPager(
        modifier = modifier
            .fillMaxWidth()
            .background(color = White),
        state = pagerState,
        pageSize = PageSize.Fixed(
            pageSize = calculatePage(LocalConfiguration.current)
        ),
        pageSpacing = Dimens.margin8,
        contentPadding = PaddingValues(
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin16
        ),
    ) { page ->
        val mission = item[page]
        LeaderMissionCard(
            index = page,
            department = department,
            jobGroup = jobGroup,
            missionName = mission.missionName,
            missionGoal = mission.missionGoal,
            period = mission.period,
            maxCondition = mission.maxCondition,
            medianCondition = mission.medianCondition,
            visibleTable = visibleTable,
            onShowTooltip = onShowToolTip,
            onPageClick = {
                scope.launch {
                    pagerState.animateScrollToPage(page)
                }
            }
        )
    }
}

private val MAX_PAGE_WIDTH = 392.dp
@Composable
private fun calculatePage(
    configuration: Configuration,
    maxPageWidth: Dp = MAX_PAGE_WIDTH,
    rate: Float = 0.85f,
): Dp {
    val screenWidth = configuration.screenWidthDp.dp
    val rateWidth = screenWidth * rate
    val pageWidth = minOf(rateWidth, maxPageWidth)
    return pageWidth
}

@Preview(name = "MissionLeaderCardPager")
@Composable
private fun PreviewMissionLeaderCardPager() {
    MissionLeaderCardPager(
        department = "음성 1센터",
        jobGroup = 1,
        item = listOf(),
        visibleTable = true,
        onPageChange = {},
        onPagerSwipe = {},
        onShowToolTip = {},
    )
}