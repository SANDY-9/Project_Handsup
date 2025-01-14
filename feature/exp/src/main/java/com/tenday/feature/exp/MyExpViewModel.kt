package com.tenday.feature.exp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.exp.GetExpDetailsUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.core.model.Exp
import com.tenday.feature.exp.model.ExpCategory
import com.tenday.feature.exp.model.ExpListState
import com.tenday.feature.exp.model.MyExpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class MyExpViewModel @Inject constructor(
    getExpDetailsUseCase: GetExpDetailsUseCase,
    getUserDetailsUseCase: GetUserDetailsUseCase,
): ViewModel() {

    private val _myExpState: MutableStateFlow<MyExpState> = MutableStateFlow(MyExpState.Loading)
    val myExpState = _myExpState.asStateFlow()

    val userDetails = getUserDetailsUseCase().shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
    )

    private val _expListState: MutableStateFlow<ExpListState> = MutableStateFlow(
        ExpListState(
            selectYear = 2025,
            selectCategory = ExpCategory.전체보기,
            data = emptyList(),
            originData = emptyMap(),
            yearCategories = emptyList(),
            showBottomSheet = false,
            showDropDown = false,
        )
    )
    val expListState = _expListState.asStateFlow()

    init {
        getExpDetailsUseCase()
            .onEach { data ->
                _myExpState.update { MyExpState.Success(data) }
                _expListState.update {
                    val expData = data.expList
                    it.copy(
                        originData = expData,
                        data = expData[it.selectYear] ?: emptyList(),
                        yearCategories = expData.keys.toList().sorted()
                    )
                }
            }.catch {
                _myExpState.value = MyExpState.Fail
            }.launchIn(viewModelScope)
    }

    internal fun updateBottomSheetVisible() {
        val state = expListState.value
        _expListState.value = state.copy(
            showBottomSheet = !state.showBottomSheet,
        )
    }

    internal fun updateDropDownVisible() {
        val state = expListState.value
        _expListState.value = state.copy(
            showDropDown = !state.showDropDown,
        )
    }

    internal fun updateSelectExpYear(year: Int) {
        val state = expListState.value
        _expListState.value = state.copy(
            selectYear = year,
            data = filterDataByYearAndCategory(state, state.selectYear),
            showBottomSheet = false,
        )
    }

    internal fun updateSelectCategory(category: ExpCategory) {
        val state = expListState.value
        _expListState.value = state.copy(
            selectCategory = category,
            data = filterDataByYearAndCategory(state, state.selectYear)
        )
    }

    private fun filterDataByYearAndCategory(state: ExpListState, year: Int): List<Exp> {
        return state.originData[year]?.filter { exp ->
            state.selectCategory == ExpCategory.전체보기 || exp.questName == state.selectCategory.name
        } ?: emptyList()
    }

}