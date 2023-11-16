package com.shevyakhov.logintest.di

import com.shevyakhov.features.splash.presentation.navigation.SplashRouter
import org.koin.dsl.module

val RouterModule = module {
	factory<SplashRouter> { SplashRouterImpl(get()) }
}