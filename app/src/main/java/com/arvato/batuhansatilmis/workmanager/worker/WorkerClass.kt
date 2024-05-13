package com.arvato.batuhansatilmis.workmanager.worker


import android.content.Context
import android.util.Log

import androidx.work.Worker
import androidx.work.WorkerParameters
import com.arvato.batuhansatilmis.workmanager.helper.NotificationHelper

class WorkerClass(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d("success", "doWork: Success function called")

        val notificationHelper = NotificationHelper(applicationContext)
        notificationHelper.showNotification()

        return Result.success()
    }
}
