package com.shevyakhov.feature.main.domain.usecase

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.shevyakhov.feature.main.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogOutUseCase(private val context: Context) {

	private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

	suspend operator fun invoke() = withContext(Dispatchers.IO) {
		val sharedPreferences = context.getSharedPreferences(context.getString(R.string.logged_shared_pref), Context.MODE_PRIVATE)

		sharedPreferences.edit()
			.putBoolean(context.getString(R.string.is_logged), false)
			.apply()

		val secretSharedPreferences: SharedPreferences.Editor = EncryptedSharedPreferences.create(
			"SECRET",
			masterKeyAlias,
			context,
			EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
			EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
		).edit()
		secretSharedPreferences.clear().apply()
	}
}