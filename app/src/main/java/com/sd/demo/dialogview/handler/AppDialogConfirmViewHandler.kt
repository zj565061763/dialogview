package com.sd.demo.dialogview.handler

import com.sd.lib.dialogview.DialogConfirmView
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler

class AppDialogConfirmViewHandler : IDialogConfirmViewHandler {
    override fun getContentViewResId(dialogView: DialogConfirmView): Int {
        return 0
    }

    override fun onContentViewChanged(dialogView: DialogConfirmView) {

    }

    override fun onAttachedToWindow(dialogView: DialogConfirmView) {
        dialogView.setTextContent("hook content")
        dialogView.setTextContentSub("hook content sub")
    }

    override fun onDetachedFromWindow(dialogView: DialogConfirmView) {

    }
}