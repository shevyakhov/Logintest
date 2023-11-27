package com.shevyakhov.features.login.domain.usecase

import com.shevyakhov.features.login.domain.entity.LoginEntity
import com.shevyakhov.features.login.domain.entity.TokenEntity
import com.shevyakhov.features.login.domain.repository.TokenRepository

class LoginUseCase(private val tokenRepository: TokenRepository) {

	suspend operator fun invoke(loginEntity: LoginEntity): TokenEntity {
		return tokenRepository.login(loginEntity)
	}
}