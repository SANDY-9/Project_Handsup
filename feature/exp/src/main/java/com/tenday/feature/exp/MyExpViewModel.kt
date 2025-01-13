package com.tenday.feature.exp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.exp.GetExpDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MyExpViewModel @Inject constructor(
    getExpDetailsUseCase: GetExpDetailsUseCase
): ViewModel() {

    init {
        getExpDetailsUseCase().onStart {

        }.onEach {
            Log.e("확인", "$it: ", )

        }.catch {

        }.launchIn(viewModelScope)
    }
}