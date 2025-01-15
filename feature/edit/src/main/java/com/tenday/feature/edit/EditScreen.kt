package com.tenday.feature.edit

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.utils.StatusBarStyle
import com.tenday.feature.edit.components.EditBadgeDialog
import com.tenday.feature.edit.components.EditBadgeView
import com.tenday.feature.edit.components.EditPasswordView
import com.tenday.feature.edit.components.EditPushSettings
import com.tenday.feature.edit.components.EditSuccessDialog
import com.tenday.feature.edit.components.EditTitleBar
import com.tenday.feature.edit.components.LogoutButton
import com.tenday.feature.edit.guide.BadgeGuideScreen
import com.tenday.feature.edit.model.EditInputState
import com.tenday.feature.edit.model.EditUiState
import com.tenday.feature.edit.model.UpdateType


@Composable
internal fun EditRoute(
    userDetails: UserDetails,
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit,
    viewModel: EditViewModel = hiltViewModel(),
) {
    StatusBarStyle(false)
    LaunchedEffect(userDetails) {
        viewModel.setUserDetails(userDetails)
    }

    val enableNoti by viewModel.notificationEnable.collectAsStateWithLifecycle()
    val editInputState by viewModel.inputState.collectAsStateWithLifecycle()
    val editUiState by viewModel.editUiState.collectAsStateWithLifecycle()
    val user by viewModel.user.collectAsStateWithLifecycle()
    val logout by viewModel.logout.collectAsStateWithLifecycle()

    val context = LocalContext.current
    LaunchedEffect(logout) {
        if(logout) {
            onLogout()
            Toast.makeText(context, "로그아웃 했습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    EditScreen(
        user = user,
        inputState = editInputState,
        enableNoti = enableNoti ?: return,
        editUiState = editUiState,
        onNavigateBack = onNavigateBack,
        onLogout = viewModel::handleLogout,
        onPwdInputChange = viewModel::updatePwdInputState,
        onPwdConfirmInputChange = viewModel::updatePwdConfirmInputState,
        onEnableNotiChange = viewModel::updateNotiChange,
        onEditComplete = viewModel::requestUpdatePwdChange,
        onDialogCancel = viewModel::resetUiState,
        onEditBadge = viewModel::requestUpdateBadgeChange,
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EditScreen(
    user: UserDetails?,
    inputState: EditInputState,
    enableNoti: Boolean,
    editUiState: EditUiState,
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit,
    onPwdInputChange: (String) -> Unit,
    onPwdConfirmInputChange: (String) -> Unit,
    onEnableNotiChange: (Boolean) -> Unit,
    onEditComplete: () -> Unit,
    onDialogCancel: () -> Unit,
    onEditBadge: (BadgeCode) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectBadge by remember { mutableStateOf(BadgeCode.NULL) }
    var visibleGuide by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Gray100)
    ) {
        stickyHeader {
            EditTitleBar(onNavigate = onNavigateBack)
        }
        item {
            EditBadgeView(
                currentBadge = user?.profileBadgeCode ?: BadgeCode.NULL,
                badgeList = user?.possibleBadgeCodeList ?: emptyList(),
                onShowBadgeInfo = { visibleGuide = true },
                onBadgeClick = { badge ->
                    selectBadge = badge
                }
            )
        }
        item {
            EditPushSettings(
                enableNoti = enableNoti,
                onCheckedChange = onEnableNotiChange,
            )
        }
        item {
            EditPasswordView(
                pwd = inputState.pwdInput,
                pwdConfirm = inputState.pwdConfirmInput,
                pwdError = inputState.pwdError,
                pwdConfirmError = inputState.pwdConfirmError,
                onPwdInputChange = onPwdInputChange,
                onPwdConfirmInputChange = onPwdConfirmInputChange,
                onEditComplete = onEditComplete,
            )
        }
        item {
            LogoutButton(onLogout = onLogout)
        }
    }

    AnimatedVisibility(editUiState is EditUiState.Success) {
        if(editUiState is EditUiState.Success) {
            EditSuccessDialog(
                editUiState.update,
                onCancel = onDialogCancel,
            )
        }
    }

    AnimatedVisibility(selectBadge != BadgeCode.NULL) {
        EditBadgeDialog(
            selectBadge = selectBadge,
            onCancel = { selectBadge = BadgeCode.NULL },
            onComplete = { badge ->
                selectBadge = BadgeCode.NULL
                onEditBadge(badge)
            },
        )
    }

    if(visibleGuide) {
        BadgeGuideScreen(onClose = { visibleGuide = false })
    }
}

@Preview(name = "EditScreen")
@Composable
private fun PreviewEditScreen() {
    EditScreen(
        user = UserDetails(
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
            possibleBadgeCodeList = BadgeCode.entries,
        ),
        inputState = EditInputState(
            pwdInput = "",
            pwdConfirmInput = "",
            pwdError = false,
            pwdConfirmError = false,
        ),
        enableNoti = true,
        editUiState = EditUiState.Success(UpdateType.PASSWORD),
        onNavigateBack = {},
        onLogout = {},
        onPwdInputChange = {},
        onPwdConfirmInputChange = {},
        onEnableNotiChange = {},
        onEditComplete = {},
        onDialogCancel = {},
        onEditBadge = {},
    )

}