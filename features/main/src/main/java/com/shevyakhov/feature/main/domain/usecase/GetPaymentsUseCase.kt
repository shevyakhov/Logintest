package com.shevyakhov.feature.main.domain.usecase

import com.shevyakhov.feature.main.domain.entity.PaymentEntity
import com.shevyakhov.feature.main.domain.repository.PaymentRepository

class GetPaymentsUseCase(private val repository: PaymentRepository) {

	suspend operator fun invoke(token: String): List<PaymentEntity> {
		return repository.getPayments(token)
	}
}