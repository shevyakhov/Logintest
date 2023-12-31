package com.shevyakhov.logintest.di

import com.shevyakhov.feature.main.presentation.navigation.HomeRouter
import com.shevyakhov.features.login.presentation.navigation.LoginRouter
import com.shevyakhov.features.splash.presentation.navigation.SplashRouter
import org.koin.dsl.module

val RouterModule = module {
	factory<SplashRouter> { SplashRouterImpl(get()) }
	factory<LoginRouter> { LoginRouterImpl(get()) }
	factory<HomeRouter> { HomeRouterImpl(get()) }
}