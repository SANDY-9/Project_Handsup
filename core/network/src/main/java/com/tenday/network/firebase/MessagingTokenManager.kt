package com.tenday.network.firebase

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MessagingTokenManager @Inject constructor(
    private val messaging: FirebaseMessaging,
) {
    fun getMessagingToken(): Flow<String> = callbackFlow {
        messaging.token.addOnSuccessListener { token ->
            trySend(token)
        }.addOnFailureListener { e ->
            close(e)
        }
        awaitClose()
    }.flowOn(Dispatchers.IO)
}