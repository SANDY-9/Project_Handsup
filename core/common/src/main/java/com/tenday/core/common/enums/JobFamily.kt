package com.tenday.core.common.enums

enum class JobFamily(val desc: String) {
    F("현장직군"),
    B("관리직군"),
    G("성장전략"),
    T("기술직군"),
    NULL("");

    companion object {
        fun getJobFamily(value: String?): JobFamily = try {
            value?.let {
                JobFamily.valueOf(it)
            } ?: NULL
        } catch (e: Exception) {
            NULL
        }
    }
}