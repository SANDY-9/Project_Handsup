package com.tenday.core.model

import kotlinx.serialization.Serializable

@Serializable
data class MissionDetails(
    val expList: List<MissionExp>,
    val maxCondition: String,
    val maxExp: String,
    val medianCondition: String,
    val medianExp: String,
    val period: String,
    val questGoal: String,
    val questName: String,
)