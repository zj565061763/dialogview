package com.sd.dialogview.handler

import com.sd.lib.dialogview.DialogProgressView
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler

class AppDialogProgressViewHandler : IDialogProgressViewHandler {
    override fun setTextMsg(dialogView: DialogProgressView, text: String?) {

    }

    override fun getContentViewResId(dialogView: DialogProgressView): Int {
        return 0
    }

    override fun onContentViewChanged(dialogView: DialogProgressView) {

    }

    override fun onAttachedToWindow(dialogView: DialogProgressView) {
        dialogView.setTextMsg("hook msg")
    }

    override fun onDetachedFromWindow(dialogView: DialogProgressView) {

    }
}