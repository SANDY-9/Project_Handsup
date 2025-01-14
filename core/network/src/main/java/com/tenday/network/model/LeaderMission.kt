package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeaderMissionResponse(
    @SerialName("department")
    val department: String,
    @SerialName("jobGroup")
    val jobGroup: Int,
    @SerialName("questCount")
    val questCount: Int,
    @SerialName("questInfo")
    val questInfo: List<LeaderQuestInfo>,
    @SerialName("totalExp")
    val totalExp: Int,
)

@Serializable
data class LeaderQuestInfo(
    @SerialName("leaderQuestResponse")
    val leaderQuest: List<QuestExp>,
    @SerialName("maxCondition")
    val maxCondition: String,
    @SerialName("maxExp")
    val maxExp: Int,
    @SerialName("medianCondition")
    val medianCondition: String,
    @SerialName("medianExp")
    val medianExp: Int,
    @SerialName("period")
    val period: String,
    @SerialName("questGoal")
    val questGoal: String,
    @SerialName("questName")
    val questName: String,
)