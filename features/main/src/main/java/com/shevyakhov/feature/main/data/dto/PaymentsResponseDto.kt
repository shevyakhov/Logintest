package com.shevyakhov.feature.main.data.dto

import com.google.gson.annotations.SerializedName

data class PaymentsResponseDto(
	@SerializedName("success") var success: String? = null,
	@SerializedName("response") var response: ArrayList<PaymentDto> = arrayListOf(),
)