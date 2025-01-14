package com.tenday.core.model

import com.tenday.core.common.enums.AchieveGrade
import kotlinx.serialization.Serializable

@Serializable
data class MissionExp(
    val achieveGrade: AchieveGrade,
    val exp: Int,
    val index: Int, // period가 week인 경우에는 주차, month인 경우에는 월
    val startDate: String = "",
    val endDate: String = "",
    val month: Int,
)
