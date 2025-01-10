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
) {
    enum class JobFamily(val desc: String) {
        F("현장직군"),
        B("관리직군"),
        G("성장전략"),
        T("기술직군");
    }
    enum class ProfileCode {
        F_A,
        F_B,
        B_A,
        B_B,
        G_A,
        G_B,
        T_A,
        T_B;
    }
    enum class BadgeCode {
        A, B, C, D, E, F;
    }
}