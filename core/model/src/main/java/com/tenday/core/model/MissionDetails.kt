package com.tenday.core.model

import com.tenday.core.common.enums.MissionPeriod
import kotlinx.serialization.Serializable

@Serializable
data class MissionDetails(
    val expList: List<MissionExp>,
    val maxCondition: String,
    val maxExp: Int,
    val medianCondition: String,
    val medianExp: Int,
    val period: MissionPeriod,
    val missionGoal: String,
    val missionName: String,
) {
    companion object {
        fun List<MissionExp>.getWeeklyExpList(): Map<Int, List<MissionExp>> {
            return sortedBy {
                it.index
            }.groupBy {
                it.month
            }
        }
    }
}