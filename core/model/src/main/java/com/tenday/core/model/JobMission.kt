package com.tenday.core.model

import kotlinx.serialization.Serializable

@Serializable
data class JobMission(
    val department: String,
    val jobGroup: Int,
    val totalExp: Int,
    val missionDetails: MissionDetails,
)