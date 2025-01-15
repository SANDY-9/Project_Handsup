package com.tenday.feature.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.ExpType
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.Exp
import com.tenday.core.model.ExpDetails
import com.tenday.core.model.ExpDetails.Companion.toExpList
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.components.HandsUpFailView
import com.tenday.designsystem.components.HandsUpLoadingView
import com.tenday.designsystem.components.profileCard.ProfileCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Backgroud
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.utils.StatusBarStyle
import com.tenday.feature.home.components.HomeExpEmptyView
import com.tenday.feature.home.components.HomeExpHistoryView
import com.tenday.feature.home.components.HomeTitleBar
import com.tenday.feature.home.model.HomeUiState
import com.tenday.feature.home.utils.getBackResId

@Composable
internal fun HomeRoute(
    onNavigateNoti: () -> Unit,
    onNavigateEdit: (UserDetails) -> Unit,
    onFinish: () -> Unit,
    onExpClick: (ExpType) -> Unit,
    onBannerClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    BackHandler(enabled = true) {
        onFinish()
    }

    val uiState by viewModel.homeUiState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    CheckPermission(
        context = context,
        onPermissionResult = viewModel::updateNotificationState,
    )
    when (val state = uiState) {
        is HomeUiState.Success -> {
            HomeScreen(
                userDetails = state.userDetails,
                expDetails = state.expDetails,
                onNavigateNoti = onNavigateNoti,
                onNavigateEdit = onNavigateEdit,
                onExpClick = onExpClick,
                onBannerClick = onBannerClick,
            )
        }
        HomeUiState.Loading -> HandsUpLoadingView()
        HomeUiState.Fail -> HandsUpFailView()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun HomeScreen(
    userDetails: UserDetails,
    expDetails: ExpDetails,
    onNavigateNoti: () -> Unit,
    onNavigateEdit: (UserDetails) -> Unit,
    onExpClick: (ExpType) -> Unit,
    onBannerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    StatusBarStyle(true)
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Backgroud,
            )
    ) {
        stickyHeader {
            HomeTitleBar(
                backResId = userDetails.jobFamily.getBackResId(),
                onNavigateNoti = onNavigateNoti
            )
        }
        item {
            val expList by remember {
                mutableStateOf(
                    expDetails.expList.toExpList()
                )
            }
            HomeContentView(
                backResId = userDetails.jobFamily.getBackResId(),
                user = userDetails,
                exp = expList,
                totalExp = expDetails.totalExp,
                expToExpectedLevel = expDetails.expToNextLevel,
                onNavigateSettings = onNavigateEdit,
                onExpClick = onExpClick,
                onBannerClick = onBannerClick,
            )
        }
    }
}

@Composable
private fun HomeContentView(
    backResId: Int,
    user: UserDetails,
    exp: List<Exp>,
    totalExp: Int,
    expToExpectedLevel: Int,
    onNavigateSettings: (UserDetails) -> Unit,
    onExpClick: (ExpType) -> Unit,
    onBannerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(208.dp, 208.dp),
            painter = painterResource(backResId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Column(
            modifier = modifier
                .fillMaxSize(),
        ) {
            ProfileCard(
                parentModifier = modifier.padding(
                    horizontal = Dimens.margin12
                ),
                department = user.department,
                employeeId = user.employeeId,
                hireDate = user.hireDate,
                jobFamily = user.jobFamily,
                jobPosition = user.jobPosition.name,
                jobLevel = user.jobLevel,
                profileBadgeCode = user.profileBadgeCode,
                profileImageCode = user.profileImageCode,
                totalExpLastYear = totalExp,
                username = user.username,
                maxExp = totalExp + expToExpectedLevel,
                onNavigateSettings = { onNavigateSettings(user) },
            )
            Spacer(modifier = modifier.height(Dimens.margin16))
            Text(
                modifier = modifier.padding(
                    horizontal = Dimens.margin20
                ),
                text = stringResource(R.string.home_exp_title),
                style = HandsUpTypography.title4
            )
            Spacer(modifier = modifier.height(Dimens.margin12))

            when {
                exp.isEmpty() -> HomeExpEmptyView()
                else -> HomeExpHistoryView(
                    expList = exp,
                    onExpClick = onExpClick,
                    onBannerClick = onBannerClick,
                )
            }
            Spacer(modifier = modifier.height(Dimens.margin24))
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
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
        expDetails = ExpDetails(
            currentLevel = "",
            currentYearExp = 2000,
            expCount = 3,
            expList = emptyMap(),
            expToNextLevel = 2000,
            expectedLevel = "",
            jobFamily = JobFamily.F,
            lastYearExp = 1223,
            totalExp = 3223,
            currentNextLevel = "",
            expToExpectedLevel = 1234,
            expToCurrentLevel = 1234,
            expToCurrentNextLevel = 1234,
        ),
        onNavigateNoti = {},
        onNavigateEdit = {},
        onExpClick = {},
        onBannerClick = {},
    )
}