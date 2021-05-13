package com.sd.lib.dialogview

import android.view.View

interface DialogConfirmView : DialogView {
    /**
     * 设置回调
     */
    fun setCallback(callback: Callback?): DialogConfirmView

    /**
     * 设置标题文字
     */
    fun setTextTitle(text: String?): DialogConfirmView

    /**
     * 设置内容文字
     */
    fun setTextContent(text: String?): DialogConfirmView

    /**
     * 设置副内容文字
     */
    fun setTextContentSub(text: String?): DialogConfirmView

    /**
     * 设置取消按钮文字
     */
    fun setTextCancel(text: String?): DialogConfirmView

    /**
     * 设置确定按钮文字
     */
    fun setTextConfirm(text: String?): DialogConfirmView

    /**
     * 设置标题文字颜色
     */
    fun setTextColorTitle(color: Int): DialogConfirmView

    /**
     * 设置内容文字颜色
     */
    fun setTextColorContent(color: Int): DialogConfirmView

    /**
     * 设置副内容文字颜色
     */
    fun setTextColorContentSub(color: Int): DialogConfirmView

    /**
     * 设置取消文字颜色
     */
    fun setTextColorCancel(color: Int): DialogConfirmView

    /**
     * 设置确认文字颜色
     */
    fun setTextColorConfirm(color: Int): DialogConfirmView

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     */
    fun setCustomView(layoutId: Int): DialogConfirmView

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     */
    fun setCustomView(view: View?): DialogConfirmView

    /**
     * 回调对象
     */
    abstract class Callback {
        /**
         * 取消按钮被点击
         */
        open fun onClickCancel(v: View, view: DialogConfirmView) {
            view.dismiss()
        }

        /**
         * 确定按钮被点击
         */
        open fun onClickConfirm(v: View, view: DialogConfirmView) {
            view.dismiss()
        }
    }
}