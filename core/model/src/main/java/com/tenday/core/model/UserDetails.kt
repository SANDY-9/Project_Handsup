package com.tenday.core.model


import com.tenday.core.common.extensions.BadgeCode
import com.tenday.core.common.extensions.JobFamily
import com.tenday.core.common.extensions.JobPosition
import com.tenday.core.common.extensions.ProfileCode
import kotlinx.serialization.Serializable

@Serializable
data class UserDetails(
    val department: String,
    val employeeId: String,
    val hireDate: String,
    val jobFamily: JobFamily,
    val jobPosition: JobPosition,
    val jobLevel: String,
    val possibleBadgeCodeList: List<BadgeCode>,
    val profileBadgeCode: BadgeCode,
    val profileImageCode: ProfileCode,
    val totalExpLastYear: Int,
    val username: String
)