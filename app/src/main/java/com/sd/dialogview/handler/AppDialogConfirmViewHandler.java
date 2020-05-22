package com.sd.dialogview.handler;

import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;

public class AppDialogConfirmViewHandler implements IDialogConfirmViewHandler
{
    @Override
    public int getContentView(DialogConfirmView dialogView)
    {
        return 0;
    }

    @Override
    public void onContentViewChanged(DialogConfirmView dialogView)
    {

    }

    @Override
    public void onAttachedToWindow(DialogConfirmView dialogView)
    {
        dialogView.setTextContent("hook content");
    }

    @Override
    public void onDetachedFromWindow(DialogConfirmView dialogView)
    {

    }
}
