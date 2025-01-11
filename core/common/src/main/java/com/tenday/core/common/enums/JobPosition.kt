package com.tenday.core.common.enums

enum class JobPosition(val position: Int) {
    파트장(1),
    대리(2),
    팀장(3),
    사원(4);

    companion object {
        fun getPosition(position: Int): JobPosition {
            return entries.find { it.position == position } ?: 사원
        }
    }
}