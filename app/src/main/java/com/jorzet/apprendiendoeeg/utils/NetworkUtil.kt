package com.jorzet.apprendiendoeeg.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {

    companion object {

        fun isConnected(context : Context): Boolean {
            val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }

    }
}
