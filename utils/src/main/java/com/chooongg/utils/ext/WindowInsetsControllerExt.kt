package com.chooongg.utils.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

fun Window.getWindowInsetsController() = WindowCompat.getInsetsController(this, decorView)

/**
 * 显示系统栏
 */
fun Fragment.showSystemBars() = activity?.showSystemBars()
fun Activity.showSystemBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .show(WindowInsetsCompat.Type.systemBars())
}

/**
 * 隐藏系统栏
 */
fun Fragment.hideSystemBars() = activity?.hideSystemBars()
fun Activity.hideSystemBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .hide(WindowInsetsCompat.Type.systemBars())
}

/**
 * 显示状态栏
 */
fun Fragment.showStatusBars() = activity?.showStatusBars()
fun Activity.showStatusBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .show(WindowInsetsCompat.Type.statusBars())
}

/**
 * 隐藏状态栏
 */
fun Fragment.hideStatusBars() = activity?.hideStatusBars()
fun Activity.hideStatusBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .hide(WindowInsetsCompat.Type.statusBars())
}

/**
 * 显示导航栏
 */
fun Fragment.showNavigationBars() = activity?.showNavigationBars()
fun Activity.showNavigationBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .show(WindowInsetsCompat.Type.navigationBars())
}

/**
 * 隐藏导航栏
 */
fun Fragment.hideNavigationBars() = activity?.hideNavigationBars()
fun Activity.hideNavigationBars() {
    WindowCompat.getInsetsController(window, window.decorView)
        .hide(WindowInsetsCompat.Type.navigationBars())
}

/**
 * 显示输入法
 */
fun Fragment.showIME(view: View? = null) = activity?.showIME(view)
fun View.showIME() = context.showIME(this)
fun Context.showIME(view: View? = null) {
    view?.requestFocus()
    val activity = getActivity() ?: return
    WindowCompat.getInsetsController(activity.window, activity.window.decorView)
        .show(WindowInsetsCompat.Type.ime())
}

/**
 * 隐藏输入法
 */
fun Fragment.hideIME() = activity?.hideIME()
fun Context.hideIME() {
    val activity = getActivity() ?: return
    WindowCompat.getInsetsController(activity.window, activity.window.decorView)
        .hide(WindowInsetsCompat.Type.ime())
}

/**
 * 设置亮色状态栏
 */
fun Fragment.setLightStatusBars(isLightMode: Boolean) =
    requireActivity().setLightStatusBars(isLightMode)

fun Activity.setLightStatusBars(isLightMode: Boolean) {
    WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
        isLightMode
}

/**
 * 是否是亮色状态栏
 */
fun Fragment.isLightStatusBars() = activity?.isLightStatusBars()
fun Activity.isLightStatusBars(): Boolean {
    return WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars
}

/**
 * 设置亮色导航栏
 */
fun Fragment.setLightNavigationBars(isLightMode: Boolean) =
    requireActivity().setLightNavigationBars(isLightMode)

fun Activity.setLightNavigationBars(isLightMode: Boolean) {
    WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars =
        isLightMode
}

/**
 * 是否是亮色导航栏
 */
fun Fragment.isLightNavigationBars() = activity?.isLightNavigationBars()
fun Activity.isLightNavigationBars(): Boolean {
    return WindowCompat.getInsetsController(window, window.decorView)
        .isAppearanceLightNavigationBars
}