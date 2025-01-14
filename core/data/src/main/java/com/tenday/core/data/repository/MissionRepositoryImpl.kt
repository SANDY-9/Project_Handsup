package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toLeaderMissionDetails
import com.tenday.core.domain.repository.MissionRepository
import com.tenday.core.model.LeaderMission
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class MissionRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource,
) : MissionRepository {
    override suspend fun getLeaderMission(token: String): LeaderMission {
        return handsUpDataSource.getLeaderMission(token).toLeaderMissionDetails()
    }
}

