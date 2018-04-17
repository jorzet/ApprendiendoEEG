package com.jorzet.apprendiendoeeg.services.webservice

import org.json.JSONObject
import android.util.Log
import com.jorzet.apprendiendoeeg.utils.HttpUtil
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

/**
 * Created by Jorge Zepeda Tinoco on 17/04/2018.
 * jorzet.94@gmail.com
 */

class HttpRequest {

    companion object {
        private val TAG : String = "HttpRequest"

        private val CONNECT_TIMEOUT : Int= 5000 // 5 seconds
        private val READ_TIMEOUT : Int = 15000 // 15 seconds
        private val OS : String= "OS"
        private val VERSION : String= "Version"
        private val CONTENT_TYPE : String= "Content-Type"
        private lateinit var json : JSONObject

        fun sendRequest(url: String, byPost : Boolean): String? {
            var urlObj: URL? = null
            try {
                urlObj = URL(url)
            } catch (e: MalformedURLException) {
            }

            var urlConnection: HttpURLConnection? = null
            try {
                urlConnection = urlObj!!.openConnection() as HttpURLConnection
                // config connection
                urlConnection.setConnectTimeout(CONNECT_TIMEOUT)
                urlConnection.setReadTimeout(READ_TIMEOUT)
                urlConnection.setUseCaches(true)
                // set header
                urlConnection.setRequestProperty(CONTENT_TYPE, HttpUtil.APLICATION_JSON)
                // set restful method
                if(byPost)
                    urlConnection.setRequestMethod(HttpUtil.RestfulMethod.POST.toString())
                else
                    urlConnection.setRequestMethod(HttpUtil.RestfulMethod.GET.toString())

                if(byPost) {
                    Log.e(HttpRequest.TAG, "json: $json")
                    val outputBytes = json.toString().toByteArray(charset("UTF-8"))
                    val os = urlConnection.getOutputStream()
                    os.write(outputBytes)
                    os.flush()
                    os.close()
                }

                val responseCode = urlConnection.getResponseCode()

                // if is connected read response in UTF-8
                if(responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = BufferedInputStream(urlConnection.getInputStream())

                    val bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
                    val total = StringBuilder()

                    bufferedReader.useLines { lines -> lines.forEach { total.append(it)} }

                    urlConnection.disconnect()

                    return total.toString()
                } else {
                    return ""
                }

            } catch (e: IOException) {
                Log.e("IOException", e.message)
                if (urlConnection != null) {
                    urlConnection.disconnect()
                }
                return null
            } finally {
                Log.i("Connection", "Get request")
                if (urlConnection != null) {
                    urlConnection.disconnect()
                }
            }
        }
    }

}