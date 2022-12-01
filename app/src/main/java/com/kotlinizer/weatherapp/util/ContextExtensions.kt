package com.kotlinizer.weatherapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

val Context.isNetworkConnected: Boolean
	get() {
		(this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).let { manager ->
			manager.activeNetwork?.let { network ->
				manager.getNetworkCapabilities(network)?.let { capabilities ->
					when {
						capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
						capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
						capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
						else -> return false
					}
				}
			}
		}
		return false
	}