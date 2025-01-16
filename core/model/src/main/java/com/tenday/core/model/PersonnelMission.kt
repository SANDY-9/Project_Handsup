package com.tenday.core.model

import com.tenday.core.common.enums.AchieveGrade
import kotlinx.serialization.Serializable

@Serializable
data class PersonnelMission(
    val achieveGrade: AchieveGrade,
    val diff: Int?,
    val exp: Int?,
    val expAt: String?,
    val term: EvaluationTerm,
) {
    enum class EvaluationTerm {
        상반기,
        하반기,
    }
    companion object {
        fun getGrade(diff: Int?) = when {
            diff == null -> "-"
            diff > 0 -> "${diff}등급"
            diff < 0 -> "${-diff}등급"
            else -> "유지"
        }
        fun isEvaluating(achieveGrade: AchieveGrade) = achieveGrade == AchieveGrade.NULL
    }
}
