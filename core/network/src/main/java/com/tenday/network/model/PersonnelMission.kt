package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PersonnelMissionResponse(
    @SerialName("achieveGrade")
    val achieveGrade: String?,
    @SerialName("diff")
    val diff: Int?,
    @SerialName("exp")
    val exp: Int,
    @SerialName("expAt")
    val expAt: String
)