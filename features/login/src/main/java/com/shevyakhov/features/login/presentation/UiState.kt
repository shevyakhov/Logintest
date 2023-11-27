package com.shevyakhov.features.login.presentation

sealed class UiState {
	class Error(val e: Throwable) : UiState()
	object Content : UiState()
}