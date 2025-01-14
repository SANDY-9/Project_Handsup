package com.tenday.feature.mission.model

import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.PersonnelMission
import com.tenday.core.model.ProjectMission

internal sealed interface HandsUpMission {
    data class Leader(
        val data: LeaderMission,
        val name: String = "리더부여",
    ): HandsUpMission
    data class Job(
        val data: JobMission,
        val name: String = "직무미션",
    ): HandsUpMission
    data class Project(
        val data: List<ProjectMission>,
        val name: String = "전사프로젝트",
    ): HandsUpMission
    data class Personnel(
        val data: List<PersonnelMission>,
        val name: String = "인사평가",
    ): HandsUpMission
}