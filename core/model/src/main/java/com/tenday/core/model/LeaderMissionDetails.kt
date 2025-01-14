package com.tenday.core.model


import kotlinx.serialization.Serializable

@Serializable
data class LeaderMissionDetails(
    val department: String,
    val jobGroup: Int,
    val questCount: Int,
    val questList: Map<String, List<MissionDetails>>,
    val totalExp: Int,
)