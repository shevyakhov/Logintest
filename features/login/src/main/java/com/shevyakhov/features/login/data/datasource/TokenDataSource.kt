package com.shevyakhov.features.login.data.datasource

import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.entity.TokenEntity

interface TokenDataSource {

	suspend fun login(loginEntity: LoginEntity): TokenEntity
}