package com.chooongg.utils.ext

import androidx.core.text.HtmlCompat

fun String.fromHtml() = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)