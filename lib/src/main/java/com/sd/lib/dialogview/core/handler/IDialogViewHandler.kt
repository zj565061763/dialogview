package com.sd.lib.dialogview.core.handler

import com.sd.lib.dialogview.DialogView

interface IDialogViewHandler<T : DialogView> {
    /**
     * 返回内容布局id
     */
    fun getContentViewResId(dialogView: T): Int

    /**
     * 内容view变化
     */
    fun onContentViewChanged(dialogView: T)

    fun onAttachedToWindow(dialogView: T)

    fun onDetachedFromWindow(dialogView: T)
}