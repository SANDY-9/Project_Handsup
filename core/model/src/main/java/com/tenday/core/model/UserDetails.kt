package com.tenday.core.model


import kotlinx.serialization.Serializable

@Serializable
data class UserDetails(
    val department: String,
    val employeeId: String,
    val hireDate: String,
    val jobFamily: JobFamily,
    val jobGroup: Int,
    val jobLevel: String,
    val possibleBadgeCodeList: List<BadgeCode>,
    val profileBadgeCode: BadgeCode,
    val profileImageCode: ProfileCode,
    val totalExpLastYear: Int,
    val username: String
)