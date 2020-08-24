package com.sd.dialogview.handler;

import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler;

public class AppDialogMenuViewHandler implements IDialogMenuViewHandler
{
    @Override
    public int getContentViewResId(DialogMenuView dialogView)
    {
        return 0;
    }

    @Override
    public void onContentViewChanged(DialogMenuView dialogView)
    {

    }

    @Override
    public void onAttachedToWindow(DialogMenuView dialogView)
    {
        dialogView.setTextTitle("hook title");
    }

    @Override
    public void onDetachedFromWindow(DialogMenuView dialogView)
    {

    }
}
