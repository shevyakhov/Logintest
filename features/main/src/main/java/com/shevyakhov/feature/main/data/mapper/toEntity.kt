package com.shevyakhov.feature.main.data.mapper

import com.shevyakhov.feature.main.data.dto.PaymentsResponseDto
import com.shevyakhov.feature.main.domain.entity.PaymentEntity

fun PaymentsResponseDto.toEntity(): List<PaymentEntity> =
	response.map {
		PaymentEntity(
			id = it.id,
			title = it.title,
			amount = it.amount,
			created = it.created
		)
	}