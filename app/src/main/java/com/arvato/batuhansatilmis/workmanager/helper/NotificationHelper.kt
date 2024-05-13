package com.arvato.batuhansatilmis.workmanager.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.arvato.batuhansatilmis.workmanager.R
import kotlin.random.Random

class NotificationHelper(private val context: Context) {

    companion object {
        const val CHANNEL_ID = "channel_id"
    }

    fun showNotification() {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Channel Name",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notificationId = Random.nextInt(0, 1000)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("New Task")
            .setContentText("Arvato Channel $notificationId")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)
        notificationManager.notify(notificationId, builder.build())
    }
}
