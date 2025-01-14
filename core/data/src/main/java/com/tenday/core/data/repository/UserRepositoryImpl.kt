package com.tenday.core.data.repository

import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.ProfileCode
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

    override suspend fun updateUserPwd(accessToken: String, pwd: String): Boolean {
        return handsUpDataSource.updateUserPwd(accessToken, pwd)
    }

    override suspend fun updateUserProfileBadge(accessToken: String, code: BadgeCode): Boolean {
        return handsUpDataSource.updateUserProfileBadge(accessToken, code.name)
    }

    override suspend fun updateUserProfileImage(accessToken: String, code: ProfileCode): Boolean {
        return handsUpDataSource.updateUserProfileImage(accessToken, code.name)
    }
}