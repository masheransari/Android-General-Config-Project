package com.org.dotinfiny.name

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class Utils {
    companion object {

        fun isConnected(context: Context): Boolean {
            var result = false
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (cm != null) {
                    val capabilities =
                        cm.getNetworkCapabilities(cm.activeNetwork)
                    if (capabilities != null) {
                        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                            result = true
                        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                            result = true
                        }
                    }
                }
            } else {
                if (cm != null) {
                    val activeNetwork = cm.activeNetworkInfo
                    if (activeNetwork != null) {
                        // connected to the internet
                        if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                            result = true
                        } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                            result = true
                        }
                    }
                }
            }
            return result
        }
    }
}