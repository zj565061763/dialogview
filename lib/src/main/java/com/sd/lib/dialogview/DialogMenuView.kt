package com.sd.lib.dialogview

import android.view.View
import android.widget.BaseAdapter

interface DialogMenuView : DialogView {
    /**
     * 设置回调
     */
    fun setCallback(callback: Callback?): DialogMenuView

    /**
     * 设置标题文字
     */
    fun setTextTitle(text: String?): DialogMenuView

    /**
     * 设置取消文字
     */
    fun setTextCancel(text: String?): DialogMenuView

    /**
     * 设置列表数据
     */
    fun setItems(vararg objects: Any): DialogMenuView

    /**
     * 设置列表数据
     */
    fun setItemList(listObject: List<Any>): DialogMenuView

    /**
     * 设置适配器
     */
    fun setAdapter(adapter: BaseAdapter?): DialogMenuView

    @Deprecated(message = "用setItemList替代")
    fun setItems(listObject: List<Any>): DialogMenuView

    abstract class Callback {
        /**
         * 位置为[index]的item项被点击
         */
        open fun onClickItem(view: View, index: Int, dialogView: DialogMenuView) {
            dialogView.dismiss()
        }

        /**
         * 取消按钮被点击
         */
        open fun onClickCancel(view: View, dialogView: DialogMenuView) {
            dialogView.dismiss()
        }
    }

    interface Item {
        /**
         * 返回Item要显示的内容
         */
        fun getItemDisplayContent(): String
    }
}