package com.tenday.feature.exp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.feature.exp.components.ExpMissionBanner
import com.tenday.feature.exp.components.MyExpHistory
import com.tenday.feature.exp.components.MyExpLastYearCard
import com.tenday.feature.exp.components.MyExpProfile
import com.tenday.feature.exp.components.MyExpThisYearCard
import com.tenday.feature.exp.model.MyExpState

@Composable
internal fun MyExpRoute(
    viewModel: MyExpViewModel = hiltViewModel()
) {
    val myExpState by viewModel.myExpState.collectAsStateWithLifecycle()

    MyExpScreen(
        myExpState = myExpState,
    )
}

@Composable
internal fun MyExpScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
            .fillMaxSize()
            .background(color = Gray100),
    if(myExpState is MyExpState.Success) {
        val data = myExpState.data
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = Gray100),
            contentPadding = PaddingValues(bottom = Dimens.margin40)
        ) {
            item {
                MyExpProfile(
                    level = data.currentLevel,
                    currentValue = data.totalExp,
                    maxValue = 27000,
                )
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
                    ExpMissionBanner()
                    MyExpThisYearCard()
                    MyExpLastYearCard()
                    MyExpHistory()
                }
            }
        }
    }
}

@Preview(name = "ExpScreen")
@Composable
private fun PreviewExpScreen() {
    MyExpScreen()
}