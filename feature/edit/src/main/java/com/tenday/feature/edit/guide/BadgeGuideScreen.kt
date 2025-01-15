package com.tenday.feature.edit.guide

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.enums.BadgeCode
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun BadgeGuideScreen(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val badgeList by remember { mutableStateOf(BadgeCode.list()) }
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        stickyHeader {
            BadgeGuideTitleBar(
                onClose = onClose,
            )
        }
        items(badgeList) { badge ->
            Column(
                modifier = modifier.padding(horizontal = Dimens.margin20)
            ) {
                BadgeGuidItem(badge)
                if(badge != badgeList.last()) {
                    HorizontalDivider(color = Gray100)
                }
            }
        }
    }

}


@Preview(name = "BadgeGuideScreen")
@Composable
private fun PreviewBadgeGuideScreen() {
    BadgeGuideScreen({})
}