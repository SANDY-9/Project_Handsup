
package com.tenday.feature.exp.lovelguide

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.enums.HandsUpLevel
import com.tenday.core.common.enums.JobFamily
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.White
import com.tenday.designsystem.utils.StatusBarStyle

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun LevelGuideScreen(
    myLevel: HandsUpLevel,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    StatusBarStyle(false)
    BackHandler(enabled = true) {
        onClose()
    }

    val levelList by remember {
        mutableStateOf(HandsUpLevel.group(myLevel))
    }
    LazyColumn(
        modifier = modifier.fillMaxSize().background(
            color = White,
        ).systemBarsPadding()
    ) {
        stickyHeader {
            LevelGuideTitleBar(
                onClose = onClose,
            )
        }
        itemsIndexed(levelList) { index, level ->
            Column(
                modifier = modifier.padding(horizontal = Dimens.margin20)
            ) {
                LevelGuidItem(level, level == myLevel)

                // 마지막 항목이 아니고, 다음 항목의 접두어가 다르면 Divider 추가
                if(level.group == JobFamily.F && index != levelList.lastIndex) {
                    val currentPrefix = level.desc.substringBefore("-")
                    val nextPrefix = levelList[index + 1].desc.substringBefore("-")

                    if (currentPrefix != nextPrefix) {
                        HorizontalDivider(color = Gray100)
                    }
                }
            }
        }
    }
}

@Preview(name = "LevelGuideScreen")
@Composable
private fun PreviewLevelGuideScreen() {
    LevelGuideScreen(HandsUpLevel.F1_I, {})
}