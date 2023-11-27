package com.shevyakhov.features.login.data.dto

import com.google.gson.annotations.SerializedName

data class TokenResponseDto(
	@SerializedName("success") var success: String? = null,
	@SerializedName("response") var response: TokenDto? = TokenDto(),
)