package com.tenday.core.data.mapper

import com.tenday.core.common.enums.BadgeCode
import com.tenday.core.common.enums.ExpType
import com.tenday.core.common.enums.JobFamily
import com.tenday.core.common.enums.JobPosition
import com.tenday.core.common.enums.ProfileCode
import com.tenday.core.model.BoardDetails
import com.tenday.core.model.Exp
import com.tenday.core.model.ExpDetails
import com.tenday.core.model.NotificationDetails
import com.tenday.core.model.UserDetails
import com.tenday.network.model.ExpData
import com.tenday.network.model.ExpResponse
import com.tenday.network.model.UserResponse

internal fun String.toDate(): String {
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

private fun String?.toBadgeCode(): BadgeCode {
    return try {
        BadgeCode.valueOf(this!!)
    } catch (e: Exception) {
        BadgeCode.NULL
    }
}

internal fun UserResponse.toUserDetails(): UserDetails {
    return UserDetails(
        department = department,
        employeeId = employeeId,
        hireDate = hireDate.toDate(),
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

internal fun List<ExpData>.toExpMap(): Map<Int, List<Exp>> {
    return map {
        Exp(
            exp = it.exp,
            expAt = it.expAt.toDate(),
            expType = ExpType.valueOf(it.expType),
            questName = it.questName,
            year = it.year
        )
    }.groupBy {
        it.year
    }
}

internal fun ExpResponse.toExpDetails(): ExpDetails {
    return ExpDetails(
        currentLevel = currentLevel,
        currentYearExp = currentYearExp,
        expCount = expCount,
        expList = expList.toExpMap(),
        expToNextLevel = expToNextLevel,
        expectedLevel = expectedLevel,
        jobFamily = JobFamily.valueOf(jobFamily),
        lastYearExp = lastYearExp,
        totalExp = totalExp,
        currentNextLevel = currentNextLevel,
        expToExpectedLevel = expToExpectedLevel,
        expToCurrentLevel = expToCurrentLevel,
        expToCurrentNextLevel = expToCurrentNextLevel,
    )
}

