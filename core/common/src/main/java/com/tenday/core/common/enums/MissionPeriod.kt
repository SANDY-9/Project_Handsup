package com.tenday.core.common.enums

enum class MissionPeriod(
    val query: String,
    val desc: String,
) {
    MONTH(query = "month", desc = "월간 미션"),
    WEEK(query = "week", desc = "주간 미션"),
    DAY(query = "day", desc = "일간 미션"),
    NULL(query = "", desc = "");

    companion object {
        fun getPeriod(period: String): MissionPeriod {
            return MissionPeriod.entries.firstOrNull {
                it.query == period
            } ?: NULL
        }
    }
}