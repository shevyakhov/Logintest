package com.shevyakhov.features.login.domain.repository

import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.entity.TokenEntity

interface TokenRepository {

	suspend fun login(loginEntity: LoginEntity): TokenEntity
}