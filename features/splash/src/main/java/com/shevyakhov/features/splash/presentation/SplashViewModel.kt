package com.shevyakhov.features.splash.presentation

import androidx.lifecycle.ViewModel
import com.shevyakhov.features.splash.presentation.navigation.SplashRouter

class SplashViewModel(private val router: SplashRouter) : ViewModel() {

	fun handleNavigation(isLogged: Boolean) {
		if (isLogged) {
			navigateToHome()
		} else
			navigateToLogin()
	}

	private fun navigateToHome() {
		router.goToHome()
	}

	private fun navigateToLogin() {
		router.goToLogin()
	}
}