package com.tenday.core.domain.usecases.mission

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.MissionRepository
import com.tenday.core.model.ProjectMission
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProjectMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    operator fun invoke(): Flow<List<ProjectMission>> {
        return flow {
            val accessToken = authPrefsRepository.getAccessToken() ?: ""
            emit(missionRepository.getProjectMission(accessToken))
        }
    }
}