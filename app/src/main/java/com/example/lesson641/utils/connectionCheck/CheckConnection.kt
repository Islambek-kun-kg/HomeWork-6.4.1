package com.example.lesson641.utils.connectionCheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class CheckConnection(context: Context) {
    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun isConnected(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val connect =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (connect != null)
                when {
                    connect.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                    connect.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                    connect.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
                    else -> false
                } else return false
        } else {
            val info = connectivityManager.activeNetworkInfo
            return info != null && info.isConnected
        }
    }
}