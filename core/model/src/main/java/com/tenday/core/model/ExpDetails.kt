package com.tenday.core.model

import kotlinx.serialization.Serializable

@Serializable
data class ExpDetails(
    val currentLevel: String,
    val currentYearExp: Int,
    val expCount: Int,
    val expList: List<Exp>,
    val expToNextLevel: Int,
    val expectedLevel: String,
    val jobFamily: String,
    val lastYearExp: Int,
    val totalExp: Int
)