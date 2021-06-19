package com.example.lesson641.utils.connectionCheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

object ConnectChecker: LiveData<Boolean>() {
    private lateinit var nCU: CheckConnection
    private lateinit var cM: ConnectivityManager

    override fun onActive() {
        registerCallback()
        super.onActive()
    }

    override fun onInactive() {
        removeCallback()
        super.onInactive()
    }

    fun checkForConnection() {
        value = nCU.isConnected()
    }

    fun init(context: Context) {
        nCU = CheckConnection(context)
        cM =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }


    private fun notifyObservers(connectionStatus: Boolean) {
        postValue(connectionStatus)
    }

    private fun registerCallback() {
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        cM.registerNetworkCallback(networkRequest, networkCallback)
    }

    private fun removeCallback() {
        cM.unregisterNetworkCallback(networkCallback)
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            notifyObservers(true)
            super.onAvailable(network)
        }

        override fun onLost(network: Network) {
            notifyObservers(false)
            super.onLost(network)
        }
    }
}