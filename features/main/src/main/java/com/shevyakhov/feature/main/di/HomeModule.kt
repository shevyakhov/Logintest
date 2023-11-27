package com.shevyakhov.feature.main.di

import com.shevyakhov.feature.main.data.api.PaymentsApi
import com.shevyakhov.feature.main.data.datasource.PaymentDataSource
import com.shevyakhov.feature.main.data.datasource.PaymentDataSourceImpl
import com.shevyakhov.feature.main.data.repository.PaymentRepositoryImpl
import com.shevyakhov.feature.main.domain.repository.PaymentRepository
import com.shevyakhov.feature.main.domain.usecase.GetPaymentsUseCase
import com.shevyakhov.feature.main.domain.usecase.GetTokenUseCase
import com.shevyakhov.feature.main.domain.usecase.LogOutUseCase
import com.shevyakhov.feature.main.presentation.HomeViewModel
import com.shevyakhov.libraries.network.createRetrofitService
import com.shevyakhov.libraries.network.getRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val HomeModule = module {

	factory { createRetrofitService<PaymentsApi>(getRetrofit()) }

	single<PaymentDataSource> { PaymentDataSourceImpl(get()) }

	single<PaymentRepository> { PaymentRepositoryImpl(get()) }

	factory { LogOutUseCase(androidContext()) }
	factory { GetPaymentsUseCase(get()) }
	factory { GetTokenUseCase(androidContext()) }

	viewModel {
		HomeViewModel(
			router = get(),
			logOutUseCase = get(),
			getPaymentsUseCase = get(),
			getTokenUseCase = get()
		)
	}
}