package com.sd.demo.dialogview.handler

import com.sd.lib.dialogview.DialogMenuView
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler

class AppDialogMenuViewHandler : IDialogMenuViewHandler {
    override fun getContentViewResId(dialogView: DialogMenuView): Int {
        return 0
    }

    override fun onContentViewChanged(dialogView: DialogMenuView) {

    }

    override fun onAttachedToWindow(dialogView: DialogMenuView) {
        dialogView.setTextTitle("hook title")
    }

    override fun onDetachedFromWindow(dialogView: DialogMenuView) {

    }
}