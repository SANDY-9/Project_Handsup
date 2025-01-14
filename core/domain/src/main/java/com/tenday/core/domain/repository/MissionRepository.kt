package com.tenday.core.domain.repository

import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.PersonnelMission
import com.tenday.core.model.ProjectMission

interface MissionRepository {
    suspend fun getLeaderMission(token: String): LeaderMission
    suspend fun getJobMission(token: String): JobMission
    suspend fun getProjectMission(token: String): List<ProjectMission>
    suspend fun getPersonnelMission(token: String): List<PersonnelMission>
}