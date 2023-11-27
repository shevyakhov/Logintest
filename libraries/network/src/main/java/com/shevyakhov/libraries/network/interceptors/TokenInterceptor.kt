package com.shevyakhov.libraries.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		val original = chain.request()
		val request = original.newBuilder()
			.header("app-key", "12345")
			.header("v", "1")
			.method(original.method, original.body)
			.build()
		return chain.proceed(request)
	}
}