package com.chooongg.utils.manager

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.LinkedList

internal object ActivityLifecycleManager : Application.ActivityLifecycleCallbacks {

    internal val activityTask = LinkedList<Activity>()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activityTask.add(activity)
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        activityTask.remove(activity)
    }
}