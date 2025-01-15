package com.tenday.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HandsUpPrefsDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    suspend fun updateAccessToken(token: String) {
        withContext(Dispatchers.IO) {
            dataStore.edit { prefs ->
                prefs[ACCESS_TOKEN] = token
            }
        }
    }

    suspend fun getAccessToken(): String? {
        return withContext(Dispatchers.IO) {
            val token = dataStore.data.map { prefs ->
                prefs[ACCESS_TOKEN]
            }.firstOrNull()
            return@withContext token
        }
    }

    suspend fun deleteAccessToken() {
        withContext(Dispatchers.IO) {
            dataStore.edit { prefs ->
                prefs.remove(ACCESS_TOKEN)
            }
        }
    }

    suspend fun updateNotificationState(enable: Boolean) {
        withContext(Dispatchers.IO) {
            dataStore.edit { prefs ->
                prefs[NOTIFICATION_ENABLE] = enable
            }
        }
    }

    fun getNotificationState(): Flow<Boolean> {
        return dataStore.data.map { prefs ->
            prefs[NOTIFICATION_ENABLE] ?: false
        }
    }

    private companion object PrefsKeys {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val NOTIFICATION_ENABLE = booleanPreferencesKey("notification_permission")
    }
}