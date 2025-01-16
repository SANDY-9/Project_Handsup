package com.tenday.service

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tenday.core.domain.usecases.user.UpdateMessagingTokenUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class HandsUpMessagingService: FirebaseMessagingService() {

    @Inject
    lateinit var updateMessagingTokenUseCase: UpdateMessagingTokenUseCase

    // 토큰 자동갱신
    override fun onNewToken(token: String) {
        flow {
            emit(updateMessagingTokenUseCase(token))
        }.onEach { result ->
            if(result) Log.i("[FCM_TOKEN]", token)
        }.catch {
            Log.e("[FCM_TOKEN]", it.message.toString())
        }.launchIn(CoroutineScope(Dispatchers.IO))
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.i("[FCM_MESSAGE]", "onMessageReceived: ${message.notification?.title}")
        Log.i("[FCM_MESSAGE]", "onMessageReceived: ${message.notification?.body}")
        createNotification(message)
    }

    @SuppressLint("MissingPermission")
    private fun createNotification(message: RemoteMessage) {
        val title = message.notification?.title
        val body = message.notification?.body

        val deepLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse("handsup://main")).apply {
            putExtra(NOTIFICATION_EXTRA, title)
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            deepLinkIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat
            .Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(com.tenday.designsystem.R.drawable.app_icon)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
        notifyNotification(notification)
    }

    @SuppressLint("MissingPermission")
    private fun notifyNotification(notification: Notification) {
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createChannel()
        notificationManager.notify(1, notification)
    }

    private fun NotificationManagerCompat.createChannel() {
        if(getNotificationChannel(CHANNEL_ID) == null){
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH,
            )
            createNotificationChannel(channel)
        }
    }

    companion object {
        private const val CHANNEL_ID = "channel_handsUp"
        private const val CHANNEL_NAME = "channel_handsUp_push"
        const val NOTIFICATION_EXTRA = "notification_title"
    }

}