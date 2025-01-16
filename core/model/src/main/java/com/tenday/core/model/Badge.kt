package com.tenday.core.model

import com.tenday.core.common.enums.BadgeCode
import kotlinx.serialization.Serializable

@Serializable
data class Badge(
    val badgeCode: BadgeCode,
    val createdAt: String,
)
