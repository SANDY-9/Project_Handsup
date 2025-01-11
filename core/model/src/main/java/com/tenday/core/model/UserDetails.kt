package com.tenday.core.model


import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
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