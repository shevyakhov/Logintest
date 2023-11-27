package com.shevyakhov.features.login.data.datasource

import com.shevyakhov.features.login.data.api.TokenApi
import com.shevyakhov.features.login.data.mapper.toEntity
import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.entity.TokenEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TokenDataSourceImpl(private val api: TokenApi) : TokenDataSource {

	override suspend fun login(loginEntity: LoginEntity): TokenEntity = withContext(Dispatchers.IO) {
		api.login(loginEntity).toEntity()
	}
}