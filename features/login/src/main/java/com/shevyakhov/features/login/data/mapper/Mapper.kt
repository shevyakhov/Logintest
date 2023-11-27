package com.shevyakhov.features.login.data.mapper

import com.shevyakhov.features.login.data.dto.TokenResponseDto
import com.shevyakhov.features.login.domain.entity.TokenEntity

internal fun TokenResponseDto.toEntity(): TokenEntity =
	TokenEntity(token = response?.token ?: error("token must not be null"))
