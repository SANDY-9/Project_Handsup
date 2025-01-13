package com.tenday.core.domain.usecases.exp

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.ExpRepository
import com.tenday.core.model.ExpDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExpDetailsUseCase @Inject constructor(
    private val expRepository: ExpRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    operator fun invoke(): Flow<ExpDetails> {
        return flow {
            val accessToken = authPrefsRepository.getAccessToken() ?: ""
            emit(expRepository.getExpDetails(accessToken))
        }
    }
}