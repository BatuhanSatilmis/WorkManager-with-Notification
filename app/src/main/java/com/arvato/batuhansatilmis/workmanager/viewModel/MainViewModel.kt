package com.arvato.batuhansatilmis.workmanager.viewModel
import androidx.lifecycle.ViewModel
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkManager.getInstance
import com.arvato.batuhansatilmis.workmanager.worker.WorkerClass
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class MainViewModel : ViewModel() {

    private val workManager: WorkManager
        get() = getInstance()

    fun startOneTimeWork() {
        val myWorkRequest = createOneTimeWorkRequest()
        workManager.enqueue(myWorkRequest)
    }

    fun startPeriodicWork() {

        val myWorkRequest = createPeriodicWorkRequest()
        workManager.enqueue(myWorkRequest)
    }

    private fun createOneTimeWorkRequest(): OneTimeWorkRequest {
        return OneTimeWorkRequest.Builder(WorkerClass::class.java)
            .build()
    }

    private val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_REQUIRED)
        .setRequiresBatteryNotLow(true).build()

    private fun createPeriodicWorkRequest(): PeriodicWorkRequest {
        return PeriodicWorkRequest.Builder(
            WorkerClass::class.java,
            15,
            TimeUnit.MINUTES
        ).setConstraints(constraints).
        build()
    }
}
