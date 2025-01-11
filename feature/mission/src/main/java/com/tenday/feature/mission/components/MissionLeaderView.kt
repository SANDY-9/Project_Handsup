package com.tenday.feature.mission.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun MissionLeaderView(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {

    }
}

@Preview(name = "MissionLeaderView")
@Composable
private fun PreviewMissionLeaderView() {
    MissionLeaderView()
}