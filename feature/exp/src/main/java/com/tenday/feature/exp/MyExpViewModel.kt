package com.tenday.feature.exp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.exp.GetExpDetailsUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.core.model.Exp
import com.tenday.feature.exp.model.ExpCategory
import com.tenday.feature.exp.model.ExpListState
import com.tenday.feature.exp.model.MyExpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class MyExpViewModel @Inject constructor(
    getExpDetailsUseCase: GetExpDetailsUseCase,
    getUserDetailsUseCase: GetUserDetailsUseCase,
): ViewModel() {

    private val _myExpUiState: MutableStateFlow<MyExpUiState> = MutableStateFlow(MyExpUiState.Loading)
    val myExpUiState = _myExpUiState.asStateFlow()

    private val _expListState: MutableStateFlow<ExpListState> = MutableStateFlow(
        ExpListState(
            selectYear = 2025,
            selectCategory = ExpCategory.전체보기,
            data = emptyList(),
            originData = emptyMap(),
            yearCategories = emptyList(),
            expCategories = ExpCategory.entries,
            showBottomSheet = false,
        )
    )
    val expListState = _expListState.asStateFlow()

    init {
        combine(
            getExpDetailsUseCase(),
            getUserDetailsUseCase(),
        ) {  expDetails, userDetails ->
            MyExpUiState.Success(
                expDetails = expDetails,
                userDetails = userDetails
            )
        }.onStart {
            _myExpUiState.value = MyExpUiState.Loading
        }.onEach { data ->
            _myExpUiState.value = data
            _expListState.update {
                val expData = data.expDetails.expList
                it.copy(
                    originData = expData,
                    data = expData.filterYearAndCategory(it.selectYear, it.selectCategory),
                    yearCategories = expData.keys.toList().sorted()
                )
            }
        }.catch {
            _myExpUiState.value = MyExpUiState.Fail
        }.launchIn(viewModelScope)
    }


    internal fun updateBottomSheetVisible() {
        val state = expListState.value
        _expListState.value = state.copy(
            showBottomSheet = !state.showBottomSheet,
        )
    }

    internal fun updateSelectExpYear(year: Int) {
        val state = expListState.value
        _expListState.value = state.copy(
            selectYear = year,
            data = state.originData.filterYearAndCategory(year, state.selectCategory),
            showBottomSheet = false,
        )
    }

    internal fun updateSelectCategory(category: ExpCategory) {
        val state = expListState.value
        _expListState.value = state.copy(
            selectCategory = category,
            data = state.originData.filterYearAndCategory(state.selectYear, category),
        )
    }

    private fun Map<Int, List<Exp>>.filterYearAndCategory(
        selectYear: Int,
        selectCategory: ExpCategory
    ): List<Exp> {
        return this[selectYear]?.filter { exp ->
            selectCategory == ExpCategory.전체보기 || selectCategory.name in exp.expType.quest
        } ?: emptyList()
    }

}