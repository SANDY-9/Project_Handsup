package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExpResponse(
    @SerialName("currentLevel")
    val currentLevel: String,
    @SerialName("currentNextLevel")
    val currentNextLevel: String,
    @SerialName("currentYearExp")
    val currentYearExp: Int,
    @SerialName("expCount")
    val expCount: Int,
    @SerialName("expList")
    val expList: List<ExpData>,
    @SerialName("expToCurrentLevel")
    val expToCurrentLevel: Int,
    @SerialName("expToCurrentNextLevel")
    val expToCurrentNextLevel: Int,
    @SerialName("expToExpectedLevel")
    val expToExpectedLevel: Int,
    @SerialName("expToNextLevel")
    val expToNextLevel: Int,
    @SerialName("expectedLevel")
    val expectedLevel: String,
    @SerialName("jobFamily")
    val jobFamily: String,
    @SerialName("lastYearExp")
    val lastYearExp: Int,
    @SerialName("totalExp")
    val totalExp: Int
)

@Serializable
data class ExpData(
    val exp: Int,
    val expAt: String,
    val expType: String,
    val questName: String,
    val year: Int,
)

