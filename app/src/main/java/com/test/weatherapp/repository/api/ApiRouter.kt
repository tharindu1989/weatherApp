package com.test.weatherapp.repository.api

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import com.test.weatherapp.config.AppConfig
import com.test.weatherapp.enums.RequestType
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class ApiRouter {

    /**
     * call backend api call
     * @param url : API URL
     * @param type API type, GET/POST/PUT
     * @param requestBody : request body for API // not implemented
     */
    fun callApi(
        url: String,
        type: RequestType = RequestType.GET,
        requestBody: Any?,
        onSuccess: (response: String) -> Unit,
        onError: () -> Unit
    ) {

        AsyncTask.execute {

            val url = URL(AppConfig.BASE_URL + url)
            val httpConnection = url.openConnection() as? HttpURLConnection
            httpConnection?.let { httpConnection ->

                httpConnection.requestMethod = type.name
                httpConnection.setRequestProperty("Content-length", "0")
                httpConnection.useCaches = true
                httpConnection.connectTimeout = 100000
                httpConnection.readTimeout = 100000

                httpConnection.connect()

                var responseString: String = ""

                when (httpConnection.responseCode) {
                    HttpURLConnection.HTTP_OK -> { // 200

                        try {

                            val bufferReader = BufferedReader(InputStreamReader(httpConnection.inputStream))

                            responseString = bufferReader.readText()

                            ViewTaskHandler.runOnUI {
                                onSuccess.invoke(responseString)
                            }

                        } catch (ex: Exception) {
                            runOnUI {
                                onError.invoke()
                            }
                        } finally {
                            httpConnection.disconnect()
                        }


                    }
                    else -> { // Other Status consider as a Error
                        runOnUI {
                            onError.invoke()
                        }
                    }
                }
            }


        }
    }

    /**
     * run on UI thread
     */
    fun runOnUI(task: () -> Unit) {
        Runnable { task.invoke() }
    }

    class ViewTaskHandler(looper: Looper) : Handler(looper) {
        companion object {
        }
    }

    fun ViewTaskHandler.Companion.runOnUI(task: () -> Unit) {
        ViewTaskHandler(Looper.getMainLooper()).post {
            task.invoke()
        }
    }

}