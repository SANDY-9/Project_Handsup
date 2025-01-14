package com.tenday.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class QuestExp(
    @SerialName("achieveGrade")
    val achieveGrade: String,
    @SerialName("exp")
    val exp: Int,
    @SerialName("index")
    val index: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("range")
    val range: List<String> = emptyList(),
)