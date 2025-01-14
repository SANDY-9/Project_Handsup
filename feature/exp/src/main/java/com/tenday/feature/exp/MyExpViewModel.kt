package com.tenday.feature.exp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.exp.GetExpDetailsUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
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
                        yearCategories = expData.keys.toList().sorted()
                    )
                }
            }.catch {
                _myExpState.value = MyExpState.Fail
            }.launchIn(viewModelScope)
    }

}