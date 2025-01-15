package com.tenday.feature.home

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
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.components.profileCard.ProfileCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Backgroud
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.home.components.HomeExpEmptyView
import com.tenday.feature.home.components.HomeExpHistoryView
import com.tenday.feature.home.components.HomeTitleBar
import com.tenday.feature.home.model.ExpListState
import com.tenday.feature.home.model.UserDetailsState
import com.tenday.feature.home.utils.getBackResId

@Composable
internal fun HomeRoute(
    onNavigateNoti: () -> Unit,
    onNavigateEdit: (UserDetails) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val userState by viewModel.userState.collectAsStateWithLifecycle()
    val expState by viewModel.expState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    CheckPermission(
        context = context,
        onPermissionResult = viewModel::updateNotificationState,
    )
    HomeScreen(
        backResId = viewModel.jobFamily.getBackResId(),
        userDetailsState = userState,
        expListState = expState,
        onNavigateNoti = onNavigateNoti,
        onNavigateEdit = onNavigateEdit,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun HomeScreen(
    userDetailsState: UserDetailsState,
    expListState: ExpListState,
    backResId: Int,
    onNavigateNoti: () -> Unit,
    onNavigateEdit: (UserDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Backgroud,
            )
    ) {
        stickyHeader {
            HomeTitleBar(
                backResId = backResId,
                onNavigateNoti = onNavigateNoti
            )
        }
        item {
            HomeContentView(
                backResId = backResId,
                user = userDetailsState,
                exp = expListState,
                onNavigateSettings = onNavigateEdit,
            )
        }
    }
}

@Composable
private fun HomeContentView(
    backResId: Int,
    user: UserDetailsState,
    exp: ExpListState,
    onNavigateSettings: (UserDetails) -> Unit,
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
            when(user) {
                is UserDetailsState.Success -> ProfileCard(
                    parentModifier = modifier.padding(
                        horizontal = Dimens.margin12
                    ),
                    department = user.data.department,
                    employeeId = user.data.employeeId,
                    hireDate = user.data.hireDate,
                    jobFamily = user.data.jobFamily,
                    jobPosition = user.data.jobPosition.name,
                    jobLevel = user.data.jobLevel,
                    profileBadgeCode = user.data.profileBadgeCode,
                    profileImageCode = user.data.profileImageCode,
                    totalExpLastYear = user.data.totalExpLastYear,
                    username = user.data.username,
                    onNavigateSettings = { onNavigateSettings(user.data) },
                )
                else -> {}
            }
            Spacer(modifier = modifier.height(Dimens.margin16))
            Text(
                modifier = modifier.padding(
                    horizontal = Dimens.margin20
                ),
                text = stringResource(R.string.home_exp_title),
                style = HandsUpTypography.title4
            )
            Spacer(modifier = modifier.height(Dimens.margin12))
            when(exp) {
                is ExpListState.EmptyExp -> HomeExpEmptyView()
                is ExpListState.Success -> HomeExpHistoryView(expList = exp.data)
                else -> {}
            }
            Spacer(modifier = modifier.height(Dimens.margin24))
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        backResId = JobFamily.F.getBackResId(),
        userDetailsState = UserDetailsState.Success(
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
            )
        ),
        expListState = ExpListState.EmptyExp,
        onNavigateNoti = {},
        onNavigateEdit = {},
    )
}