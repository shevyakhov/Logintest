package com.shevyakhov.feature.main.data.dto

import com.google.gson.annotations.SerializedName

data class PaymentDto(
	@SerializedName("id") var id: Int? = null,
	@SerializedName("title") var title: String? = null,
	@SerializedName("amount") var amount: String? = null,
	@SerializedName("created") var created: Int? = null,
)