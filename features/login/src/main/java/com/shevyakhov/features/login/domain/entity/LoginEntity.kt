package com.shevyakhov.features.login.domain.entity

import java.io.Serializable

data class LoginEntity(
	val login: String,
	val password: String,
) : Serializable
