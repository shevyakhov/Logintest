package com.shevyakhov.feature.main.presentation

import com.shevyakhov.feature.main.domain.entity.PaymentEntity

sealed class UiState {
	object Initial : UiState()
	class Error(val e: Throwable) : UiState()
	class Content(val data: List<PaymentEntity>) : UiState()
}