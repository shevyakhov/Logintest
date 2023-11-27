package com.shevyakhov.features.login.domain.usecase

import android.content.Context

import com.shevyakhov.features.login.R

class UserLoggedUseCase(private val context: Context) {

	suspend operator fun invoke() {
		val sharedPreferences = context.getSharedPreferences(context.getString(R.string.logged_shared_pref), Context.MODE_PRIVATE)

		sharedPreferences.edit()
			.putBoolean(context.getString(R.string.is_logged), true)
			.apply()
	}
}