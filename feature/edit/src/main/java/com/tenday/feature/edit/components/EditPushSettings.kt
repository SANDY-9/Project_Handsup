package com.tenday.feature.edit.components

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.components.Switchoff
import com.tenday.designsystem.components.Switchon
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.theme.CardShadowLight
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.edit.R

@Composable
internal fun EditPushSettings(
    enableNoti: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val permissionsLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            context.showEnableNotiMessage()
            onCheckedChange(true)
        } else {
            context.showDisableNotiMessage()
        }
    }

    var switchChecked by remember { mutableStateOf(enableNoti) }
    var isInitial by remember { mutableStateOf(true) } // 초기 상태 관리
    LaunchedEffect(switchChecked) {
        if(isInitial) {
            isInitial = false
            return@LaunchedEffect
        }
        if(switchChecked) {
            if (context.hasNotiPermission()) {
                onCheckedChange(true)
                context.showEnableNotiMessage()
            } else {
                permissionsLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            onCheckedChange(false)
            context.showDisableNotiMessage()
        }
    }

    Box(
        modifier = modifier.padding(
            horizontal = Dimens.margin20,
            vertical = Dimens.margin12,
        )
    ) {
        HandsUpShadowCard(
            shadowColor = CardShadowLight,
            offsetY = 2.dp,
            content = {
                Row(
                    modifier = modifier
                        .padding(
                            horizontal = Dimens.margin20,
                        )
                        .height(56.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.edit_set_push_title),
                        style = HandsUpTypography.title5,
                    )
                    Spacer(modifier = modifier.weight(1f))
                    when {
                        switchChecked -> {
                            Image(
                                modifier = modifier
                                    .size(
                                        width = 52.dp,
                                        height = 28.dp
                                    )
                                    .noRippleClickable { switchChecked = false },
                                imageVector = Icons.Switchon,
                                contentDescription = null,
                            )
                        }
                        else -> {
                            Image(
                                modifier = modifier
                                    .size(
                                        width = 52.dp,
                                        height = 28.dp
                                    )
                                    .noRippleClickable {
                                        switchChecked = true
                                    },
                                imageVector = Icons.Switchoff,
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        )
    }
}

private fun Context.showEnableNotiMessage() {
    Toast.makeText(this, "푸시알림을 허용합니다.", Toast.LENGTH_SHORT).show()
}

private fun Context.showDisableNotiMessage() {
    Toast.makeText(this, "푸시알림을 거부했습니다.", Toast.LENGTH_SHORT).show()
}

private fun Context.hasNotiPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.POST_NOTIFICATIONS
    ) == PackageManager.PERMISSION_GRANTED
}

@Preview(name = "EditPushSettings")
@Composable
private fun PreviewEditPushSettings() {
    EditPushSettings(
        false,
        {},
    )
}