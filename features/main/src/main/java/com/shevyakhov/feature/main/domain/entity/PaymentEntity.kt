package com.shevyakhov.feature.main.domain.entity

data class PaymentEntity(
	var id: Int? = null,
	var title: String? = null,
	var amount: String? = null,
	var created: Int? = null,
)
