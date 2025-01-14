package com.tenday.core.model

import com.tenday.core.common.enums.AchieveGrade
import kotlinx.serialization.Serializable

@Serializable
data class MissionExp(
    val achieveGrade: AchieveGrade,
    val exp: Int,
    val index: Int,
    val month: Int,
)
