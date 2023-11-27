package com.shevyakhov.features.login.data.repository

import com.shevyakhov.features.login.data.datasource.TokenDataSource
import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.entity.TokenEntity
import com.shevyakhov.features.login.domain.repository.TokenRepository

class TokenRepositoryImpl(private val dataSource: TokenDataSource) : TokenRepository {

	override suspend fun login(loginEntity: LoginEntity): TokenEntity {
		return dataSource.login(loginEntity)
	}
}