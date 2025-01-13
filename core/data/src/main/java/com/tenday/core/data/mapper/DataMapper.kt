package com.tenday.core.data.mapper

import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
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

private fun String.toBadgeCode(): BadgeCode {
    return try {
        BadgeCode.valueOf(this)
    } catch (e: IllegalArgumentException) {
        BadgeCode.ANNUAL_MVP_2024
    }
}

internal fun UserResponse.toUserDetails(): UserDetails {
    return UserDetails(
        department = department,
        employeeId = employeeId,
        hireDate = hireDate,
        jobFamily = JobFamily.valueOf(jobFamily),
        jobPosition = JobPosition.getPosition(jobPosition),
        jobGroup = jobGroup,
        jobLevel = jobLevel,
        possibleBadgeCodeList = possibleBadgeCodeList.map { it.toBadgeCode() },
        profileBadgeCode = profileBadgeCode.toBadgeCode(),
        profileImageCode = ProfileCode.valueOf(profileImageCode),
        totalExpLastYear = totalExpLastYear,
        username = username,
    )
}