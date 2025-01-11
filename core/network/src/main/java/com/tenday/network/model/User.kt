package com.tenday.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val department: String,
    val employeeId: String,
    val hireDate: String,
    val jobFamily: String,
    val jobGroup: Int,
    val jobLevel: String,
    val possibleBadgeCodeList: List<String>,
    val profileBadgeCode: String,
    val profileImageCode: String,
    val totalExpLastYear: Int,
    val username: String
)