package com.tenday.feature.splash

import androidx.lifecycle.ViewModel
import com.tenday.core.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
): ViewModel() {

    suspend fun getAccessToken(): String? {
        return getAccessTokenUseCase()
    }

}