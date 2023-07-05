package com.chooongg.utils

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.chooongg.utils.manager.ApplicationManager
import com.chooongg.utils.manager.NightModeManager

class ChooonggUtilsInitializer : Initializer<String> {
    override fun create(context: Context): String {
        ApplicationManager.initialize(context as Application)
        NightModeManager.initialize(context)
        return "ChooonggUtils is initialized"
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}