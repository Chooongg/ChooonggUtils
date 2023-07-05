package com.chooongg.utils.ext

import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.widget.TextView
import com.chooongg.utils.SpannableStyle

fun CharSequence.style(init: SpannableStyle.() -> Unit): SpannableStyle =
    SpannableStyle(this).apply {
        init()
        return this
    }

fun TextView.setText(span: SpannableStyle) {
    for (style in span.styles.iterator()) {
        if (style is URLSpan) {
            movementMethod = LinkMovementMethod()
            break
        }
    }
    text = span.toSpannableString()
}