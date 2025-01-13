package com.tenday.feature.exp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.exp.GetExpDetailsUseCase
import com.tenday.core.domain.usecases.user.GetUserDetailsUseCase
import com.tenday.feature.exp.model.MyExpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
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

    private val _currentExpListYear: MutableStateFlow<Int> = MutableStateFlow(2025)
    val currentExpListYear = _currentExpListYear.asStateFlow()

    init {
        getExpDetailsUseCase()
            .onEach { data ->
                _myExpState.value = MyExpState.Success(data)
            }.catch {
                _myExpState.value = MyExpState.Fail
            }.launchIn(viewModelScope)
    }

    fun updateSelectExpYear(year: Int) {
        _currentExpListYear.value = year
    }


}