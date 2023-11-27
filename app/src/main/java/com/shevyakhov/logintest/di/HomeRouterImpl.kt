package com.shevyakhov.logintest.di

import com.shevyakhov.feature.main.presentation.navigation.HomeRouter
import com.shevyakhov.features.login.LoginDestination
import com.shevyakhov.libraries.navigation.MainRouter

class HomeRouterImpl(private val router: MainRouter) : HomeRouter {

	override fun logout() {
		router.replace(LoginDestination)
	}
}
