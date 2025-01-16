package com.tenday.feature.mission

import com.tenday.core.common.enums.ExpType

internal enum class MissionMenu {
    리더부여,
    직무미션,
    전사프로젝트,
    인사평가,
    NULL;

    companion object {
        fun String.toMissionMenu(): MissionMenu {
            return when(this) {
                ExpType.J.name -> 직무미션
                ExpType.C.name -> 전사프로젝트
                ExpType.H1.name, ExpType.H2.name -> 인사평가
                ExpType.L.name -> 리더부여
                else -> NULL
            }
        }
    }
}