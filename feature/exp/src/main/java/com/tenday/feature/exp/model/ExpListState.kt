package com.tenday.feature.exp.model

import com.tenday.core.model.Exp

internal data class ExpListState(
    val selectYear: Int,
    val selectCategory: ExpCategory,
    val data: List<Exp>,
    val originData: Map<Int, List<Exp>>,
    val yearCategories: List<Int>,
)

internal enum class ExpCategory {
    전체보기,
    리더부여,
    직무미션,
    전사프로젝트,
    인사평가,
}