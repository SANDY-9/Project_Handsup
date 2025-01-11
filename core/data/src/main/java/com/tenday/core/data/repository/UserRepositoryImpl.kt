package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toUserDetails
import com.tenday.core.domain.repository.UserRepository
import com.tenday.core.model.UserDetails
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource
) : UserRepository {
    override suspend fun getUserDetails(token: String): UserDetails {
        return handsUpDataSource.getUserDetails(token).toUserDetails()
    }
}