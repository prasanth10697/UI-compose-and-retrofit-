package com.spider.composeapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeApp:Application() {

    companion object {
        const val TAG = "ComposeApp"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ****** Hilt android application *****")
    }
}