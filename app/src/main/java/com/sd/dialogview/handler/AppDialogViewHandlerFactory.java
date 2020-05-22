package com.sd.dialogview.handler;

import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.IDialogViewHandlerFactory;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler;

public class AppDialogViewHandlerFactory implements IDialogViewHandlerFactory
{
    @Override
    public IDialogProgressViewHandler newProgressViewHandler(DialogProgressView dialogView)
    {
        return new AppDialogProgressViewHandler();
    }

    @Override
    public IDialogConfirmViewHandler newConfirmViewHandler(DialogConfirmView dialogView)
    {
        return new AppDialogConfirmViewHandler();
    }

    @Override
    public IDialogMenuViewHandler newMenuViewHandler(DialogMenuView dialogView)
    {
        return new AppDialogMenuViewHandler();
    }
}
