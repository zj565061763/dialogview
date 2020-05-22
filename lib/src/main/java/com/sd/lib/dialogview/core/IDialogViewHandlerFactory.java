package com.sd.lib.dialogview.core;

import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler;

public interface IDialogViewHandlerFactory
{
    IDialogProgressViewHandler newProgressViewHandler(DialogProgressView dialogView);

    IDialogConfirmViewHandler newConfirmViewHandler(DialogConfirmView dialogView);

    IDialogMenuViewHandler newMenuViewHandler(DialogMenuView dialogView);
}
