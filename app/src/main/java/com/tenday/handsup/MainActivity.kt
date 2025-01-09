package com.tenday.handsup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.tenday.designsystem.theme.HandsUpTheme
import com.tenday.feature.login.login.navigation.LoginRoute
import com.tenday.handsup.ui.HandsUpApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandsUpTheme {
                HandsUpApp(
                    navController = rememberNavController(),
                    startDestination = LoginRoute,
                )
            }
        }
    }
}