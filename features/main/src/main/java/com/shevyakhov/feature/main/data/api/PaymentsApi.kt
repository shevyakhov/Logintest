package com.shevyakhov.feature.main.data.api

import com.shevyakhov.feature.main.data.dto.PaymentsResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface PaymentsApi {

	@GET("./payments")
	suspend fun getPayments(@Header("token") token: String): PaymentsResponseDto
}