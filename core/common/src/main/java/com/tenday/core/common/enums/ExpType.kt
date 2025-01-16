package com.tenday.core.common.enums

enum class ExpType(val quest: String) {
    J("직무미션"),
    H1("상반기 인사평가"),
    H2("하반기 인사평가"),
    L("리더부여"),
    C("전사프로젝트"),
    NULL("");

    companion object {
        fun getExpType(value: String?): ExpType = try {
            value?.let {
                ExpType.valueOf(it)
            } ?: NULL
        } catch (e: Exception) {
            NULL
        }
    }
}