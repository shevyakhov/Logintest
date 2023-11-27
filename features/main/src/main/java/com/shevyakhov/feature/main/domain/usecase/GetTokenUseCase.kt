package com.shevyakhov.feature.main.domain.usecase

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class GetTokenUseCase(context: Context) {

	private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

	private val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
		"SECRET",
		masterKeyAlias,
		context,
		EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
		EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
	)

	operator fun invoke(): String? {
		return sharedPreferences.getString("TOKEN", null)
	}
}