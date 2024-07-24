package com.example.demowasmandroid

import android.util.Log
import com.dylibso.chicory.log.Logger

class LoggerBridge(private val tag: String): Logger {
    override fun log(level: Logger.Level, msg: String, throwable: Throwable?) {
        Log.e(tag, msg)
    }

    override fun isLoggable(level: Logger.Level): Boolean {
        return true
    }

}