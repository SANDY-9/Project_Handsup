package com.tenday.core.model


import kotlinx.serialization.Serializable

@Serializable
data class LeaderMission(
    val department: String,
    val jobGroup: Int,
    val missionCount: Int,
    val missionList: List<MissionDetails>,
    val totalExp: Int,
)