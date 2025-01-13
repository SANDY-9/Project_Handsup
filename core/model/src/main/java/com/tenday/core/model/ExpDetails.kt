package com.tenday.core.model

import com.tenday.core.common.enums.JobFamily
import kotlinx.serialization.Serializable

@Serializable
data class ExpDetails(
    val currentLevel: String,
    val currentYearExp: Int,
    val expCount: Int,
    val expList: Map<Int, List<Exp>>,
    val expToNextLevel: Int,
    val expectedLevel: String,
    val jobFamily: JobFamily,
    val lastYearExp: Int,
    val totalExp: Int
)