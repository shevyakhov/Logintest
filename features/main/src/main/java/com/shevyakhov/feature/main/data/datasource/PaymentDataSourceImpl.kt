package com.shevyakhov.feature.main.data.datasource

import com.shevyakhov.feature.main.data.api.PaymentsApi
import com.shevyakhov.feature.main.data.mapper.toEntity
import com.shevyakhov.feature.main.domain.entity.PaymentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PaymentDataSourceImpl(private val api: PaymentsApi) : PaymentDataSource {

	override suspend fun getPayments(token: String): List<PaymentEntity> = withContext(Dispatchers.IO) {
		api.getPayments(token).toEntity()
	}
}
