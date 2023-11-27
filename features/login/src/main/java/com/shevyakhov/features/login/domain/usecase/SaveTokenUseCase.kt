package com.shevyakhov.features.login.domain.usecase

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveTokenUseCase(context: Context) {

	private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

	private val sharedPreferences: SharedPreferences.Editor = EncryptedSharedPreferences.create(
		"SECRET",
		masterKeyAlias,
		context,
		EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
		EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
	).edit()

	suspend operator fun invoke(token: String) = withContext(Dispatchers.IO) {
		sharedPreferences.putString("TOKEN", token).apply()
	}
}