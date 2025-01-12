package com.tenday.feature.mission.components.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.feature.mission.R
import com.tenday.feature.mission.components.MissionExpTitle

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectMissionView(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Dimens.margin20,
            end = Dimens.margin20,
            bottom = Dimens.margin24,
            top = 0.dp
        ),
    ) {
        stickyHeader {
            MissionExpTitle(
                type = stringResource(R.string.mission_project_title)
            )
        }
        items(5) {
            ProjectMissionCard()
            Spacer(modifier = modifier.height(Dimens.margin12))
        }
    }
}

@Preview(name = "ProjectMissionView")
@Composable
private fun PreviewProjectMissionView() {
    ProjectMissionView()
}