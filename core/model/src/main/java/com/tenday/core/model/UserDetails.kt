package com.tenday.core.model


import com.tenday.core.common.BadgeCode
import com.tenday.core.common.JobFamily
import com.tenday.core.common.JobPosition
import com.tenday.core.common.ProfileCode
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