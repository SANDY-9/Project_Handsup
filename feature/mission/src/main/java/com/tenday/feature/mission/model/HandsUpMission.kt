package com.tenday.feature.mission.model

import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.PersonnelMission
import com.tenday.core.model.ProjectMission

internal sealed interface HandsUpMission {
    data class Leader(
        val mission: LeaderMission,
        val name: String = "리더부여",
    ): HandsUpMission
    data class Job(
        val mission: JobMission,
        val name: String = "직무미션",
    ): HandsUpMission
    data class Project(
        val mission: List<ProjectMission>,
        val name: String = "전사프로젝트",
    ): HandsUpMission
    data class Personnel(
        val mission: List<PersonnelMission>,
        val name: String = "인사평가",
    ): HandsUpMission
}