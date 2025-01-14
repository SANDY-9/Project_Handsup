package com.tenday.core.domain.repository

import com.tenday.core.model.LeaderMissionDetails

interface MissionRepository {
    suspend fun getLeaderMission(token: String): LeaderMissionDetails
}