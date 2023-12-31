package com.shevyakhov.logintest

import android.app.Application
import com.shevyakhov.feature.main.di.HomeModule
import com.shevyakhov.features.login.di.LoginModule
import com.shevyakhov.features.splash.di.SplashModule
import com.shevyakhov.libraries.network.di.BACKEND
import com.shevyakhov.libraries.network.di.NetworkModule
import com.shevyakhov.logintest.di.AppModule
import com.shevyakhov.logintest.di.RouterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			properties(
				mapOf(BACKEND to BuildConfig.BASE_URL),
			)

			androidContext(this@App)
			modules(AppModule)
			modules(RouterModule)
			modules(NetworkModule)

			modules(SplashModule)
			modules(LoginModule)
			modules(HomeModule)
		}
	}
}