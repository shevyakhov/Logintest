package com.shevyakhov.feature.main.domain.repository

import com.shevyakhov.feature.main.domain.entity.PaymentEntity

interface PaymentRepository {

	suspend fun getPayments(token: String): List<PaymentEntity>
}