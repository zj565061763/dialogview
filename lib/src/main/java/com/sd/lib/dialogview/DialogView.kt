package com.sd.lib.dialogview

import com.sd.lib.dialog.IDialog
import com.sd.lib.dialoger.Dialoger

interface DialogView {
    @Deprecated("see dialogv")
    val dialoger: Dialoger

    val dialogv: IDialog

    fun dismiss()
}