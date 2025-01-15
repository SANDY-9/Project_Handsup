package com.tenday.core.model

import com.tenday.core.common.enums.JobFamily
import kotlinx.serialization.Serializable

@Serializable
data class ExpDetails(
    val currentLevel: String,
    val currentNextLevel: String,
    val currentYearExp: Int,
    val expCount: Int,
    val expList: Map<Int, List<Exp>>,
    val expToNextLevel: Int,
    val expToExpectedLevel: Int,
    val expectedLevel: String,
    val expToCurrentLevel: Int,
    val expToCurrentNextLevel: Int,
    val jobFamily: JobFamily,
    val lastYearExp: Int,
    val totalExp: Int
) {
    companion object {
        fun Map<Int, List<Exp>>.toExpList(): List<Exp> {
            return values
                .flatten()
                .sortedByDescending {
                    it.expAt
                }
        }
    }
}