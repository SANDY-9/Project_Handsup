package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


class ProjectMissionResponse : ArrayList<ProjectMissionItem>()

@Serializable
data class ProjectMissionItem(
    @SerialName("content")
    val content: String,
    @SerialName("exp")
    val exp: Int,
    @SerialName("expAt")
    val expAt: String,
    @SerialName("period")
    val period: String,
    @SerialName("questName")
    val questName: String
)