package com.shevyakhov.features.login.data.api

import com.shevyakhov.features.login.data.dto.TokenResponseDto
import com.shevyakhov.features.login.domain.entity.LoginEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenApi {

	@POST("./login")
	suspend fun login(@Body login: LoginEntity): TokenResponseDto
}