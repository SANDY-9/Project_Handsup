package com.tenday.feature.exp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.ExpDetails
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.components.HandsUpFailView
import com.tenday.designsystem.components.HandsUpLoadingView
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.utils.StatusBarStyle
import com.tenday.feature.exp.components.ExpMissionBanner
import com.tenday.feature.exp.components.MyExpHistory
import com.tenday.feature.exp.components.MyExpLastYearCard
import com.tenday.feature.exp.components.MyExpProfile
import com.tenday.feature.exp.components.MyExpThisYearCard
import com.tenday.feature.exp.components.MyExpYearListBottomSheet
import com.tenday.feature.exp.model.ExpCategory
import com.tenday.feature.exp.model.ExpListState
import com.tenday.feature.exp.model.MyExpUiState
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun MyExpRoute(
    onNavigateMission:() -> Unit,
    viewModel: MyExpViewModel = hiltViewModel()
) {
    val myExpUiState by viewModel.myExpUiState.collectAsStateWithLifecycle()
    val expListState by viewModel.expListState.collectAsStateWithLifecycle()
    Box {
        when(val state = myExpUiState) {
            is MyExpUiState.Success -> MyExpScreen(
                user = state.userDetails,
                exp = state.expDetails,
                expListState = expListState,
                onBannerClick = onNavigateMission,
                onShowYearBottomSheet = viewModel::updateBottomSheetVisible,
                onBottomSheetComplete = viewModel::updateSelectExpYear,
                onSelectCategory = viewModel::updateSelectCategory,
            )
            MyExpUiState.Loading -> HandsUpLoadingView()
            MyExpUiState.Fail -> HandsUpFailView()
        }
    }
}

@Composable
internal fun MyExpScreen(
    user: UserDetails,
    exp: ExpDetails,
    expListState: ExpListState,
    onBannerClick:() -> Unit,
    onShowYearBottomSheet: () -> Unit,
    onBottomSheetComplete: (Int) -> Unit,
    onSelectCategory: (ExpCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    StatusBarStyle(true)

    val listState = rememberLazyListState()
    var visibleDropDown by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Gray100),
        contentPadding = PaddingValues(bottom = Dimens.margin40),
        state = listState,
    ) {
        item {
            MyExpProfile(
                user = user,
                currentTotalExp = exp.totalExp,
                requireExp = exp.expToNextLevel,
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
                ExpMissionBanner(
                    userName = user.username,
                    onBannerClick = onBannerClick,
                    modifier = modifier.pointerInput(Unit) {
                        detectTapGestures {
                            visibleDropDown = false
                        }
                    }
                )
                MyExpThisYearCard(
                    currentYearExp = exp.currentYearExp,
                    expectLevel = exp.expectedLevel,
                    modifier = modifier.pointerInput(Unit) {
                        detectTapGestures {
                            visibleDropDown = false
                        }
                    }
                )
                MyExpLastYearCard(
                    currentLevel = exp.currentNextLevel,
                    previousLevel = exp.currentLevel,
                    lastYearExp = exp.lastYearExp,
                    currentLevelTotalExp = exp.totalExp + exp.expToNextLevel,
                    modifier = modifier.pointerInput(Unit) {
                        detectTapGestures {
                            visibleDropDown = false
                        }
                    }
                )
                MyExpHistory(
                    selectYear = expListState.selectYear,
                    selectCategory = expListState.selectCategory,
                    data = expListState.data,
                    categoryEntry = expListState.expCategories,
                    visibleDropDown = visibleDropDown,
                    onSelectCategory = {
                        onSelectCategory(it)
                        visibleDropDown = false
                    },
                    onShowYearBottomSheet = {
                        onShowYearBottomSheet()
                        visibleDropDown = false
                    },
                    onShowCategoryDropdown = {
                        visibleDropDown = !visibleDropDown
                    },
                    modifier = modifier.pointerInput(Unit) {
                        detectTapGestures {
                            visibleDropDown = false
                        }
                    }
                )
            }
        }
    }
    AnimatedVisibility(
        expListState.showBottomSheet
    ) {
        MyExpYearListBottomSheet(
            selectedYear = expListState.selectYear,
            yearList = expListState.yearCategories,
            onComplete = onBottomSheetComplete,
        )
    }

    var statusSpaceColor by remember { mutableStateOf(Color.Transparent) }
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collectLatest { (index, offset) ->
                statusSpaceColor = when {
                    offset == 0 -> Color.Transparent
                    index == 0 -> Color(0xFF333d4c)
                    else -> Gray100
                }
            }
    }

    StatusBarStyle(statusSpaceColor != Gray100)

    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(
                color = statusSpaceColor,
            )
    )
}

@Preview(name = "ExpScreen")
@Composable
private fun PreviewExpScreen() {
    MyExpScreen(
        UserDetails(
            employeeId = "2023010101",
            username = "김민수",
            hireDate = "2023-01-01",
            department = "음성 1센터",
            jobPosition = JobPosition.파트장,
            jobGroup = 1,
            jobFamily = JobFamily.F,
            jobLevel = "F1-Ⅰ",
            totalExpLastYear = 5000,
            profileImageCode = ProfileCode.F_A,
            profileBadgeCode = BadgeCode.EXP_EVERY_MONTH_FOR_A_YEAR,
            possibleBadgeCodeList = emptyList()
        ),
        ExpDetails(
            currentLevel = "F1-Ⅰ",
            currentYearExp = 5730,
            expCount = 7,
            expList = emptyMap(),
            expToNextLevel = 7770,
            expectedLevel = "F1-Ⅰ",
            jobFamily = JobFamily.F,
            lastYearExp = 0,
            totalExp = 5730,
            currentNextLevel = "F1-Ⅰ",
            expToExpectedLevel = 12345,
            expToCurrentLevel = 12345,
            expToCurrentNextLevel = 12345,
        ),
        ExpListState(
            selectYear = 2025,
            selectCategory = ExpCategory.전체보기,
            data = listOf(),
            originData = emptyMap(),
            yearCategories = listOf(2025, 2024),
            expCategories = ExpCategory.entries,
            false,
        ),
        {},
        {},
        {},
        {},
    )
}