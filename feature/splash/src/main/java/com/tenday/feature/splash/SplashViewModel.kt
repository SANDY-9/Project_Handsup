package com.tenday.feature.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.auth.GetAccessTokenUseCase
import com.tenday.core.domain.usecases.user.UpdateMessagingTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
    updateMessagingTokenUseCase: UpdateMessagingTokenUseCase,
): ViewModel() {

    val splashShow = flow {
        delay(200)
        emit(false)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = true,
    )

    suspend fun getAccessToken(): String? {
        return getAccessTokenUseCase()
    }

    init {
        updateMessagingTokenUseCase().onEach {
            Log.e("확인1", "$it: ", )
        }.catch {
            Log.e("확인2", ": $it", )
        }.launchIn(viewModelScope)
    }

}