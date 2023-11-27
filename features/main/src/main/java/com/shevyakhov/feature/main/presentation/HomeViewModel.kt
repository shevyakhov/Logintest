package com.shevyakhov.feature.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevyakhov.feature.main.domain.usecase.GetPaymentsUseCase
import com.shevyakhov.feature.main.domain.usecase.GetTokenUseCase
import com.shevyakhov.feature.main.domain.usecase.LogOutUseCase
import com.shevyakhov.feature.main.presentation.navigation.HomeRouter
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
	private val router: HomeRouter,
	private val logOutUseCase: LogOutUseCase,
	private val getPaymentsUseCase: GetPaymentsUseCase,
	private val getTokenUseCase: GetTokenUseCase,

	) : ViewModel() {

	private val handler = CoroutineExceptionHandler { _, throwable ->
		_uiState.value = UiState.Error(throwable)
	}

	private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
	val uiState: StateFlow<UiState>
		get() = _uiState

	fun logout() = viewModelScope.launch(handler) {
		logOutUseCase.invoke()
		router.logout()
	}

	fun getPayments() = viewModelScope.launch(handler) {
		val token = getTokenUseCase()
		if (token == null) {
			logout()
		} else {
			val payments = getPaymentsUseCase(token)
			_uiState.value = UiState.Content(payments)
			Log.e("LOG", payments.toString())
		}
	}
}