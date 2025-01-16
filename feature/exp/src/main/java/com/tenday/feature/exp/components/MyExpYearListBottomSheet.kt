@file:OptIn(ExperimentalMaterial3Api::class)

package com.tenday.feature.exp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpButton
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.icons.Cancel
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White
import com.tenday.feature.exp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyExpYearListBottomSheet(
    selectedYear: Int,
    yearList: List<Int>,
    onComplete: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    var selectYear by remember { mutableStateOf(selectedYear) }

    ModalBottomSheet(
        sheetState = bottomSheetState,
        dragHandle = null,
        onDismissRequest = { onComplete(selectedYear) },
        containerColor = White,
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                modifier = modifier.fillMaxWidth().padding(
                    top = Dimens.margin28,
                    start = Dimens.margin20,
                    end = Dimens.margin20,
                    bottom = Dimens.margin16,
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.exp_bottom_sheet_title),
                    style = HandsUpTypography.title3.copy(
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Spacer(modifier = modifier.weight(1f))
                Icon(
                    modifier = modifier
                        .size(24.dp)
                        .noRippleClickable { onComplete(selectedYear) },
                    imageVector = Icons.Cancel,
                    contentDescription = null,
                )
            }
            LazyColumn(
                modifier = modifier.heightIn(
                    max = 212.dp,
                    min = 144.dp,
                ),
            ) {
                itemsIndexed(yearList) { index, year ->
                    MyExpYearItem(
                        year = year,
                        selected = year == selectYear,
                        visibleDivider = index < yearList.lastIndex,
                        onSelect = { selectYear = year },
                    )
                }
            }
            Box(
                modifier = modifier.padding(Dimens.margin20)
            ) {
                HandsUpButton(
                    modifier = modifier.align(Alignment.Center),
                    text = stringResource(R.string.exp_bottom_sheet_btn_title),
                    enabled = true,
                    onClick = { onComplete(selectYear) },
                )
            }
        }
    }
}

@Composable
private fun MyExpYearItem(
    year: Int,
    selected: Boolean,
    visibleDivider: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect)
            .padding(horizontal = Dimens.margin20),
    ) {
        Text(
            modifier = modifier.padding(vertical = Dimens.margin13).padding(start = Dimens.margin2),
            text = "${year}년",
            style = HandsUpTypography.title5,
            color = if(selected) HandsUpOrange else Gray900,
        )
        if(visibleDivider) {
            HorizontalDivider(color = Gray100)
        }
    }
}

@Preview(name = "MyExpYearListBottomSheet")
@Composable
private fun PreviewMyExpYearListBottomSheet() {
    MyExpYearListBottomSheet(
        2024,
        listOf(2025,2024,2023,2022,2021),
        {},
    )
    //MyExpYearItem(2025, false, true, {})
}