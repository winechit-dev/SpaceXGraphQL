package com.winechitpaing.apollographql

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object User {
    private const val KEY_TOKEN = "TOKEN"
    @RequiresApi(Build.VERSION_CODES.M)
    private fun preferences(context: Context): SharedPreferences {
        val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            "secret_shared_prefs",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        return sharedPreferences
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun getToken(context: Context): String? {
        return preferences(context).getString(KEY_TOKEN, null)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setToken(context: Context, token: String) {
        preferences(context).edit().apply {
            putString(KEY_TOKEN, token)
            apply()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun removeToken(context: Context) {
        preferences(context).edit().apply {
            remove(KEY_TOKEN)
            apply()
        }
    }
}