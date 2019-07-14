package com.test.weatherapp.extention

import android.os.Handler
import android.os.Looper

/**
 * Created By Tharindu on 7/14/2019
 *
 */
class ViewTaskHandler(looper: Looper) : Handler(looper) {
    companion object {
    }
}

fun ViewTaskHandler.Companion.runOnUI(task: () -> Unit) {
    ViewTaskHandler(Looper.getMainLooper()).post {
        task.invoke()
    }
}