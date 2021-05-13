package com.sd.lib.dialogview

interface DialogProgressView : DialogView {
    /**
     * 设置是否拦截触摸事件
     */
    fun setConsumeTouchEvent(consume: Boolean): DialogProgressView

    /**
     * 设置显示的文字
     */
    fun setTextMsg(text: String?): DialogProgressView
}