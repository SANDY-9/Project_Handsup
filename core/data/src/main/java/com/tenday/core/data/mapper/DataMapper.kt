package com.tenday.core.data.mapper

import com.tenday.core.model.BoardDetails
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
private fun formatTimestampToDate(timestamp: String): String {
    val parsedDate = LocalDateTime.parse(timestamp)
    return parsedDate.format(formatter)
}

internal fun List<BoardDetails>.toBoardDetails(): List<BoardDetails> {
    return map {
        it.copy(
            createdAt = formatTimestampToDate(it.createdAt)
        )
    }
}