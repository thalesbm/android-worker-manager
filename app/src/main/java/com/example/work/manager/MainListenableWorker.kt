package com.example.work.manager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.concurrent.futures.ResolvableFuture
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.google.common.util.concurrent.ListenableFuture

class MainListenableWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : ListenableWorker(appContext, workerParams) {

    private lateinit var future: ResolvableFuture<Result>

    @SuppressLint("RestrictedApi")
    override fun startWork(): ListenableFuture<Result> {
        future = ResolvableFuture.create()

        Log.d("THALES", "1")
        Thread.sleep(1000)
        Log.d("THALES", "2")
        Thread.sleep(1000)
        Log.d("THALES", "3")

        val t = object : MainListenableWorkerInterface {
            override fun success() {
                val work = workDataOf("demo" to true)
                future.set(Result.success(work))
            }

            override fun failure() {
                future.set(Result.failure())
            }
        }

        // t.success()
        t.failure()

        return future
    }
}

interface MainListenableWorkerInterface {
    fun success()
    fun failure()
}
