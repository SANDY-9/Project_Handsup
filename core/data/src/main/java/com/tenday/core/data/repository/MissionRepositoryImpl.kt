package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toJobMission
import com.tenday.core.data.mapper.toLeaderMission
import com.tenday.core.data.mapper.toProjectMission
import com.tenday.core.domain.repository.MissionRepository
import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.ProjectMission
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class MissionRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource,
) : MissionRepository {
    override suspend fun getLeaderMission(token: String): LeaderMission {
        return handsUpDataSource.getLeaderMission(token).toLeaderMission()
    }

    override suspend fun getJobMission(token: String): JobMission {
        return handsUpDataSource.getJobMission(token).toJobMission()
    }

    override suspend fun getProjectMission(token: String): List<ProjectMission> {
        return handsUpDataSource.getProjectMission(token).toProjectMission()
    }
}

