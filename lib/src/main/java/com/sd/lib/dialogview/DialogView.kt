package com.sd.lib.dialogview

import com.sd.lib.dialoger.Dialoger

interface DialogView {
    val dialoger: Dialoger

    fun dismiss()
}