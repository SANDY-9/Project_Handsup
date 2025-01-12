package com.tenday.feature.exp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.feature.exp.components.ExpMissionBanner
import com.tenday.feature.exp.components.MyExpHistory
import com.tenday.feature.exp.components.MyExpLastYearCard
import com.tenday.feature.exp.components.MyExpProfile
import com.tenday.feature.exp.components.MyExpThisYearCard

@Composable
internal fun MyExpRoute() {
    MyExpScreen()
}

@Composable
internal fun MyExpScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Gray100),
        contentPadding = PaddingValues(bottom = Dimens.margin40)
    ) {
        item {
            MyExpProfile("F2-Ⅱ", currentValue = 14000,)
        }
        item {
            Column(
                modifier = modifier.padding(
                    top = Dimens.margin12,
                    start = Dimens.margin20,
                    end = Dimens.margin20,
                ),
                verticalArrangement = Arrangement.spacedBy(Dimens.margin12),
            ) {
                ExpMissionBanner("김민수")
                MyExpThisYearCard()
                MyExpLastYearCard()
                MyExpHistory()
            }
        }
    }
}

@Preview(name = "ExpScreen")
@Composable
private fun PreviewExpScreen() {
    MyExpScreen()
}