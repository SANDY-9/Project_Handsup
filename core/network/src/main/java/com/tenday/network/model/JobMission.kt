package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobMissionResponse(
    @SerialName("department")
    val department: String,
    @SerialName("jobGroup")
    val jobGroup: Int,
    @SerialName("jobQuestResponse")
    val jobQuest: List<QuestExp>,
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
    @SerialName("totalExp")
    val totalExp: Int
)