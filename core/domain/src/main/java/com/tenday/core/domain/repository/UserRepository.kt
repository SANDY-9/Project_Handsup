package com.tenday.core.domain.repository

import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.UserDetails

interface UserRepository {
    suspend fun getUserDetails(token: String): UserDetails
    suspend fun updateUserPwd(accessToken: String, pwd: String): Boolean
    suspend fun updateUserProfileBadge(accessToken: String, code: BadgeCode): Boolean
    suspend fun updateUserProfileImage(accessToken: String, code: ProfileCode): Boolean
}