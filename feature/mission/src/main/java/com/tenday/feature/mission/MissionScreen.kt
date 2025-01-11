
package com.tenday.feature.mission

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.feature.mission.navigation.MissionRoute

@Composable
internal fun MissionRoute() {
    MissionScreen()
}

@Composable
internal fun MissionScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "MissionScreen")
    }
}

@Preview(name = "MissionScreen")
@Composable
private fun PreviewMissionScreen() {
    MissionScreen()
}