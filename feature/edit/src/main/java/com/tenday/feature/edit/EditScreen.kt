package com.tenday.feature.edit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.UserDetails
import com.tenday.designsystem.theme.Gray100
import com.tenday.feature.edit.components.EditBadgeView
import com.tenday.feature.edit.components.EditPasswordView
import com.tenday.feature.edit.components.EditPushSettings
import com.tenday.feature.edit.components.EditTitleBar
import com.tenday.feature.edit.model.EditInputState


@Composable
internal fun EditRoute(
    onNavigateBack: () -> Unit,
) {
    val userDetails = UserDetails(
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
    )
    val editInputState = EditInputState(
        pwdInput = "",
        pwdConfirmInput = "",
        pwdError = false,
        pwdConfirmError = false,
    )
    EditScreen(
        user = userDetails,
        inputState = editInputState,
        onNavigateBack = onNavigateBack,
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EditScreen(
    user: UserDetails,
    inputState: EditInputState,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(true) }
    var pwd by remember { mutableStateOf("") }
    var pwdConfirm by remember { mutableStateOf("") }
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
                currentBadge = user.profileBadgeCode,
                badgeList = user.possibleBadgeCodeList,
                onShowBadgeInfo = {},
            )
        }
        item {
            EditPushSettings(
                checked = checked,
                onCheckedChange = { checked = !checked }
            )
        }
        item {
            EditPasswordView(
                pwd = inputState.pwdInput,
                pwdConfirm = inputState.pwdConfirmInput,
                pwdError = inputState.pwdError,
                pwdConfirmError = inputState.pwdConfirmError,
                onPwdInputChange = {},
                onPwdConfirmInputChange = {},
                onEditComplete = {}
            )
        }
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
        onNavigateBack = {}
    )

}