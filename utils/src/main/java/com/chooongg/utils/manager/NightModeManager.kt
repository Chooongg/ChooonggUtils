package com.chooongg.utils.manager

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode

object NightModeManager {

    private lateinit var sp: SharedPreferences

    internal fun initialize(context: Context) {
        sp = context.getSharedPreferences("ChooonggUtils", Context.MODE_PRIVATE)
        sp.getInt("NightMode", AppCompatDelegate.MODE_NIGHT_NO).let {
            AppCompatDelegate.setDefaultNightMode(it)
        }
    }

    fun getNightMode() = AppCompatDelegate.getDefaultNightMode()

    fun setNightMode(@NightMode mode: Int) {
        sp.edit().putInt("NightMode", mode).apply()
    }

    fun isNightMode(context: Context) =
        when (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> true
            else -> false
        }
}