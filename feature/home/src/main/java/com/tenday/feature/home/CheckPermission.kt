package com.tenday.feature.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat

@Composable
internal fun CheckPermission(
    context: Context,
    onPermissionResult: suspend (Boolean) -> Unit,
) {
    var permissionResult by remember { mutableStateOf<Boolean?>(null) }

    val permissionsLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        /** 권한 요청시 동의 했을 경우 **/
        if (isGranted) {
            Toast.makeText(context, "푸시알림 권한이 동의되었습니다.", Toast.LENGTH_SHORT).show()
            Log.d("[NOTIFICATION_PERMISSION]", "Permission Allowed")
        }
        /** 권한 요청시 거부 했을 경우 **/
        else {
            Toast.makeText(context, "푸시알림 권한을 허용해주세요.", Toast.LENGTH_SHORT).show()
            Log.d("[NOTIFICATION_PERMISSION]", "Permission Denied")
        }
        permissionResult = isGranted
    }

    val hasNotificationPermission = ContextCompat.checkSelfPermission(
        context, Manifest.permission.POST_NOTIFICATIONS
    ) == PackageManager.PERMISSION_GRANTED

    LaunchedEffect(hasNotificationPermission) {
        if(!hasNotificationPermission) {
            permissionsLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
    LaunchedEffect(permissionResult) {
        permissionResult?.let { isGranted ->
            onPermissionResult(isGranted)
        }
    }
}