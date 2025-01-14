package com.tenday.core.common.enums

enum class MissionPeriod(val desc: String) {
    MONTH("month"),
    WEEK("week"),
    DAY("day"),
    NULL("");

    companion object {
        fun getPeriod(period: String): MissionPeriod {
            return MissionPeriod.entries.firstOrNull {
                it.desc == period
            } ?: NULL
        }
    }
}