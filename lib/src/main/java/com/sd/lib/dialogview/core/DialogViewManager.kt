package com.sd.lib.dialogview.core

import com.sd.lib.dialogview.DialogConfirmView
import com.sd.lib.dialogview.DialogMenuView
import com.sd.lib.dialogview.DialogProgressView
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler

object DialogViewManager {
    var dialogViewHandlerFactory: IDialogViewHandlerFactory = object : IDialogViewHandlerFactory {
        override fun newProgressViewHandler(dialogView: DialogProgressView): IDialogProgressViewHandler? {
            return null
        }

        override fun newConfirmViewHandler(dialogView: DialogConfirmView): IDialogConfirmViewHandler? {
            return null
        }

        override fun newMenuViewHandler(dialogView: DialogMenuView): IDialogMenuViewHandler? {
            return null
        }
    }
}