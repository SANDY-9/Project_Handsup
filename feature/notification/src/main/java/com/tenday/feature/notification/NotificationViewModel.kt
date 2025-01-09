package com.tenday.feature.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenday.core.domain.usecases.notification.GetNotificationListUseCase
import com.tenday.feature.notification.model.NotificationUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class NotificationViewModel @Inject constructor(
    getNotificationListUseCase: GetNotificationListUseCase
): ViewModel() {

    private val _notifyUiState = MutableStateFlow<NotificationUiState>(NotificationUiState.Loading)
    val notifyUiState: StateFlow<NotificationUiState> get() = _notifyUiState

    init {
        flow {
            emit(getNotificationListUseCase())
        }.onEach { data ->
            _notifyUiState.value = if(data.isEmpty()) {
                NotificationUiState.EmptyItem
            }
            else {
                NotificationUiState.Success(data)
            }
        }.catch {
            _notifyUiState.value = NotificationUiState.Fail
        }.launchIn(viewModelScope)
    }

}