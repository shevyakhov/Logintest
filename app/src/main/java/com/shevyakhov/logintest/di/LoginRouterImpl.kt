package com.shevyakhov.logintest.di

import com.shevyakhov.feature.main.HomeDestination
import com.shevyakhov.features.login.presentation.navigation.LoginRouter
import com.shevyakhov.libraries.navigation.MainRouter

class LoginRouterImpl(private val router: MainRouter) : LoginRouter {

	override fun navigateToHomeFragment() {
		router.replace(HomeDestination)
	}
}
