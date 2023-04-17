package com.example.work.manager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initWork()
        initListenableWorker()
    }

    private fun initListenableWorker() {
        val oneTimeRequest = OneTimeWorkRequest.Builder(MainListenableWorker::class.java).build()
        WorkManager.getInstance().enqueue(oneTimeRequest)

        WorkManager.getInstance()
            .getWorkInfoByIdLiveData(oneTimeRequest.id)
            .observe(this, Observer {
                Log.d("THALES", "state " + it.state)
                if (it.state == WorkInfo.State.SUCCEEDED) {
                    val result = it.outputData.getBoolean("demo", false)
                    Log.d("THALES", "result $result")
                }
            })
    }

    private fun initWork() {
        val oneTimeRequest = OneTimeWorkRequest.Builder(MainWorker::class.java).build()
        WorkManager.getInstance().enqueue(oneTimeRequest)

        WorkManager.getInstance()
            .getWorkInfoByIdLiveData(oneTimeRequest.id)
            .observe(this, Observer {
                Log.d("THALES", "state " + it.state)
                if (it.state == WorkInfo.State.SUCCEEDED) {
                    val result = it.outputData.getBoolean("demo", false)
                    Log.d("THALES", "result $result")
                }
            })
    }
}
