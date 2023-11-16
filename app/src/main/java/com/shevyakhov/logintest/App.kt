package com.shevyakhov.logintest

import android.app.Application
import com.shevyakhov.features.splash.di.SplashModule
import com.shevyakhov.logintest.di.AppModule
import com.shevyakhov.logintest.di.RouterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			modules(AppModule)
			modules(RouterModule)

			modules(SplashModule)
		}
	}
}