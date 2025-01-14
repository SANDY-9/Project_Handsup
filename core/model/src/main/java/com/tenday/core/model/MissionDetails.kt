package com.tenday.core.model

import com.tenday.core.common.enums.MissionPeriod
import kotlinx.serialization.Serializable

@Serializable
data class MissionDetails(
    val expList: List<MissionExp>,
    val maxCondition: String,
    val maxExp: String,
    val medianCondition: String,
    val medianExp: String,
    val period: MissionPeriod,
    val missionGoal: String,
    val missionName: String,
)