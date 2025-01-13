package com.tenday.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Exp(
    val exp: Int,
    val expAt: String,
    val expType: String,
    val questName: String,
    val year: Int,
)