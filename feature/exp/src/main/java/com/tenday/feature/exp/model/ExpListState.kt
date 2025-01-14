package com.tenday.feature.exp.model

import com.tenday.core.model.Exp

internal data class ExpListState(
    val selectYear: Int,
    val selectCategory: ExpCategory,
    val data: List<Exp>,
    val originData: Map<Int, List<Exp>>,
    val yearCategories: List<Int>,
    val expCategories: List<ExpCategory>,
    val showBottomSheet: Boolean,
    val showDropDown: Boolean,
)

internal enum class ExpCategory(val desc: String) {
    전체보기("전체"),
    리더부여("리더부여"),
    직무미션("직무미션"),
    전사프로젝트("전사프로젝트"),
    인사평가("인사평가"),
}