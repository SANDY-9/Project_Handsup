package com.tenday.core.common.enums

enum class AchieveGrade(val alias: String) {
    MAX("MAX"),
    MIN("MIN"),
    MEDIAN("MEDIAN"),
    S등급("S"),
    A등급("A"),
    B등급("B"),
    C등급("C"),
    D등급("D"),
    NULL("심사중");

    companion object {
        fun getGrade(value: String?): AchieveGrade = try {
            value?.let {
                AchieveGrade.valueOf(it)
            } ?: NULL
        } catch (e: Exception) {
            NULL
        }
    }
}