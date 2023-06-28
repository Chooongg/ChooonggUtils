package com.chooongg.utils

import android.Manifest
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import com.chooongg.utils.ext.connectivityManager

/**
 * 网络工具类
 */
object NetworkUtils {

    /**
     * 当前是否连接网络
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isNetworkConnected(): Boolean {
        val cm = APPLICATION.connectivityManager
        return cm.getNetworkCapabilities(cm.activeNetwork)?.run {
            hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    && hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } ?: false
    }

    /**
     * 当前使用WIFI连接网络
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isNetworkWifiConnected(): Boolean {
        val cm = APPLICATION.connectivityManager
        return cm.getNetworkCapabilities(cm.activeNetwork)?.run {
            hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        } ?: false
    }

    /**
     * 当前使用蜂窝网络连接网络
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun currentNetWorkStatusIsCellular(): Boolean {
        val cm = APPLICATION.connectivityManager
        return cm.getNetworkCapabilities(cm.activeNetwork)?.run {
            hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    && hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                    && hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } ?: false
    }
}