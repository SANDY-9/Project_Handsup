package com.tenday.core.model

import com.tenday.core.common.enums.AchieveGrade
import kotlinx.serialization.Serializable

@Serializable
data class PersonnelMission(
    val achieveGrade: AchieveGrade,
    val diff: Int?,
    val exp: Int,
    val expAt: String?,
)
