package com.tenday.core.data.mapper

import com.tenday.core.model.BoardDetails
import com.tenday.core.model.NotificationDetails

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