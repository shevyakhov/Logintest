package com.shevyakhov.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.usecase.LoginUseCase
import com.shevyakhov.features.login.domain.usecase.SaveTokenUseCase
import com.shevyakhov.features.login.domain.usecase.UserLoggedUseCase
import com.shevyakhov.features.login.presentation.navigation.LoginRouter
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
	private val router: LoginRouter,
	private val loginUseCase: LoginUseCase,
	private val saveTokenUseCase: SaveTokenUseCase,
	private val userLoggedUseCase: UserLoggedUseCase,
) : ViewModel() {

	private val handler = CoroutineExceptionHandler { _, throwable ->
		_uiState.value = UiState.Error(throwable)
	}

	private val _uiState = MutableStateFlow<UiState>(UiState.Content)
	val uiState: StateFlow<UiState>
		get() = _uiState

	fun login(login: String, password: String) = viewModelScope.launch(handler) {
		_uiState.value = UiState.Content
		val loginEntity = LoginEntity(login, password)
		val token = loginUseCase(loginEntity)
		saveTokenUseCase.invoke(token = token.token)
		userLoggedUseCase.invoke()
		router.navigateToHomeFragment()
	}
}
