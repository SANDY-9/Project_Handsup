package com.tenday.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ExpResponse(
    val currentLevel: String,
    val currentYearExp: Int,
    val expCount: Int,
    val expList: List<ExpData>,
    val expToNextLevel: Int,
    val expectedLevel: String,
    val jobFamily: String,
    val lastYearExp: Int,
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