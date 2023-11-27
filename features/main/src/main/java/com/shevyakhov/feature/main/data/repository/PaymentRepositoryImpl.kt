package com.shevyakhov.feature.main.data.repository

import com.shevyakhov.feature.main.data.datasource.PaymentDataSource
import com.shevyakhov.feature.main.domain.entity.PaymentEntity
import com.shevyakhov.feature.main.domain.repository.PaymentRepository

class PaymentRepositoryImpl(private val dataSource: PaymentDataSource) : PaymentRepository {

	override suspend fun getPayments(token: String): List<PaymentEntity> {
		return dataSource.getPayments(token)
	}
}