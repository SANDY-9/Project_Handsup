package com.tenday.service

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class HandsUpMessagingService: FirebaseMessagingService() {

    // 토큰 자동갱신
    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.e("확인", "onMessageReceived: $message", )
        createNotification(message)
    }

    @SuppressLint("MissingPermission")
    private fun createNotification(message: RemoteMessage) {
        val title = message.notification?.title
        val body = message.notification?.body
        val notification = NotificationCompat
            .Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(com.tenday.designsystem.R.drawable.test)
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
    }

}