package com.tenday.core.domain.usecases.mission

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.MissionRepository
import com.tenday.core.model.PersonnelMission
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPersonnelMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    operator fun invoke(): Flow<List<PersonnelMission>> {
        return flow {
            val accessToken = authPrefsRepository.getAccessToken() ?: ""
            emit(missionRepository.getPersonnelMission(accessToken))
        }
    }
}