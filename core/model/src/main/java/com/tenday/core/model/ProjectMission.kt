package com.tenday.core.model

import com.tenday.core.common.enums.MissionPeriod
import kotlinx.serialization.Serializable

@Serializable
data class ProjectMission(
    val content: String,
    val exp: Int,
    val expAt: String,
    val period: MissionPeriod,
    val missionName: String,
)
