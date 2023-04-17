package com.example.work.manager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MainWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        simulateRequest()

        val work = workDataOf("demo" to true)

        return Result.success(work)
    }

    private fun simulateRequest() {
        Log.d("THALES", "1")
        Thread.sleep(1000)
        Log.d("THALES", "2")
        Thread.sleep(1000)
        Log.d("THALES", "3")
        Thread.sleep(1000)
        Log.d("THALES", "4")
        Thread.sleep(1000)
        Log.d("THALES", "5")
        Thread.sleep(1000)
        Log.d("THALES", "6")
        Thread.sleep(1000)
    }
}
