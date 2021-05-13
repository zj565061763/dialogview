package com.sd.lib.dialogview.core.handler

import com.sd.lib.dialogview.DialogProgressView

interface IDialogProgressViewHandler : IDialogViewHandler<DialogProgressView> {
    fun setTextMsg(dialogView: DialogProgressView, text: String?)
}