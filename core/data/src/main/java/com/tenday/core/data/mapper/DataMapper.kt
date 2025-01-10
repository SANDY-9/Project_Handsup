package com.tenday.core.data.mapper

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.core.model.UserDetails
import com.tenday.network.model.UserResponse

private fun String.toDate(): String {
    val datePart = substringBefore("T")
    return datePart.replace("-", ".")
}

internal fun List<BoardDetails>.toBoardDetails(): List<BoardDetails> {
    return map {
        it.copy(
            createdAt = it.createdAt.toDate()
        )
    }
}

internal fun List<NotificationDetails>.toNotificationDetails(): List<NotificationDetails> {
    return map {
        it.copy(
            createdAt = it.createdAt.toDate()
        )
    }
}

private fun String.toBadgeCode(): UserDetails.BadgeCode {
    return UserDetails.BadgeCode.valueOf(this)
}

internal fun UserResponse.toUserDetails(): UserDetails {
    return UserDetails(
        department = department,
        employeeId = employeeId,
        hireDate = hireDate,
        jobFamily = UserDetails.JobFamily.valueOf(jobFamily),
        jobGroup = jobGroup,
        jobLevel = jobLevel,
        possibleBadgeCodeList = possibleBadgeCodeList.map { it.toBadgeCode() },
        profileBadgeCode = profileBadgeCode.toBadgeCode(),
        profileImageCode = UserDetails.ProfileCode.valueOf(profileImageCode),
        totalExpLastYear = totalExpLastYear,
        username = username,
    )
}