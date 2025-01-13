package com.tenday.core.model

import com.tenday.core.common.enums.ExpType
import kotlinx.serialization.Serializable

@Serializable
data class Exp(
    val exp: Int,
    val expAt: String,
    val expType: ExpType,
    val questName: String,
    val year: Int,
)