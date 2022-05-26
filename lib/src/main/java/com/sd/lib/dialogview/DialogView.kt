package com.sd.lib.dialogview

import com.sd.lib.dialog.IDialog

interface DialogView {
    val dialog: IDialog

    fun dismiss()
}