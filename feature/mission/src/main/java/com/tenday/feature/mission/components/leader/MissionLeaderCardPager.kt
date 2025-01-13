
package com.tenday.feature.mission.components.leader

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.White
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun MissionLeaderCardPager(
    jobFamily: String,
    jobGroup: Int,
    visibleTable: Boolean,
    onPageChange: (Int) -> Unit,
    onShowImproveToolTip: (IntOffset) -> Unit,
    onShowSpecialTooltip: (IntOffset) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState (pageCount = { 2 })
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            onPageChange(page)
        }
    }
    HorizontalPager(
        modifier = modifier.background(color = White),
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
        when(page) {
            0 -> ImproveWorkMissionCard(
                jobFamily = jobFamily,
                jobGroup = jobGroup,
                visibleTable = visibleTable,
                onShowImproveToolTip = onShowImproveToolTip,
            )
            else -> SpecialWorkMissionCard(
                jobFamily = jobFamily,
                jobGroup = jobGroup,
                visibleTable = visibleTable,
                onShowSpecialTooltip = onShowSpecialTooltip,
            )
        }
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
    MissionLeaderCardPager("음성 1센터", 1,true, {}, {}, {})
}