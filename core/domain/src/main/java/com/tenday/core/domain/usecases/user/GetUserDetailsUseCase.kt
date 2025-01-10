package com.tenday.core.domain.usecases.user

import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.UserRepository
import com.tenday.core.model.UserDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val authPrefsRepository: AuthPrefsRepository,
) {
    operator fun invoke(): Flow<UserDetails> {
        return flow {
            val accessToken = authPrefsRepository.getAccessToken() ?: ""
            val userDetails = userRepository.getUserDetails(accessToken)
            emit(userDetails)
        }
    }

}