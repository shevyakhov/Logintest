package com.shevyakhov.features.login.di

import com.shevyakhov.features.login.data.api.TokenApi
import com.shevyakhov.features.login.data.datasource.TokenDataSource
import com.shevyakhov.features.login.data.datasource.TokenDataSourceImpl
import com.shevyakhov.features.login.data.repository.TokenRepositoryImpl
import com.shevyakhov.features.login.domain.repository.TokenRepository
import com.shevyakhov.features.login.domain.usecase.LoginUseCase
import com.shevyakhov.features.login.domain.usecase.SaveTokenUseCase
import com.shevyakhov.features.login.domain.usecase.UserLoggedUseCase
import com.shevyakhov.features.login.presentation.LoginViewModel
import com.shevyakhov.libraries.network.createRetrofitService
import com.shevyakhov.libraries.network.getRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginModule = module {

	factory { createRetrofitService<TokenApi>(getRetrofit()) }

	single<TokenDataSource> { TokenDataSourceImpl(get()) }

	single<TokenRepository> { TokenRepositoryImpl(get()) }

	factory { LoginUseCase(get()) }
	factory { SaveTokenUseCase(androidContext()) }
	factory { UserLoggedUseCase(androidContext()) }

	viewModel {
		LoginViewModel(
			router = get(),
			loginUseCase = get(),
			saveTokenUseCase = get(),
			userLoggedUseCase = get()
		)
	}
}
