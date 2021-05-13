package com.sd.lib.dialogview.core

import com.sd.lib.dialogview.DialogConfirmView
import com.sd.lib.dialogview.DialogMenuView
import com.sd.lib.dialogview.DialogProgressView
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler

interface IDialogViewHandlerFactory {
    fun newProgressViewHandler(dialogView: DialogProgressView): IDialogProgressViewHandler?

    fun newConfirmViewHandler(dialogView: DialogConfirmView): IDialogConfirmViewHandler?

    fun newMenuViewHandler(dialogView: DialogMenuView): IDialogMenuViewHandler?
}