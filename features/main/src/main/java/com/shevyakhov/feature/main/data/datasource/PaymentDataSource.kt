package com.shevyakhov.feature.main.data.datasource

import com.shevyakhov.feature.main.domain.entity.PaymentEntity

interface PaymentDataSource {

	suspend fun getPayments(token: String): List<PaymentEntity>
}