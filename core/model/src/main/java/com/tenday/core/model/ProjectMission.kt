package com.tenday.core.model

import kotlinx.serialization.Serializable

@Serializable
data class ProjectMission(
    val content: String,
    val exp: Int,
    val expAt: String,
    val period: String,
    val missionName: String,
)
