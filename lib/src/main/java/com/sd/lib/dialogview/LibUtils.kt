package com.sd.lib.dialogview

import android.text.TextUtils
import android.view.View
import android.widget.TextView

internal object LibUtils {
    @JvmStatic
    fun setTextAndVisibility(text: String?, textView: TextView?) {
        textView?.let {
            it.text = text
            it.visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        }
    }
}