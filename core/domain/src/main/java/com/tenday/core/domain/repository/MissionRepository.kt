package com.tenday.core.domain.repository

import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission

interface MissionRepository {
    suspend fun getLeaderMission(token: String): LeaderMission
    suspend fun getJobMission(token: String): JobMission
}