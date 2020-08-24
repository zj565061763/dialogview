package com.sd.dialogview.handler;

import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler;

public class AppDialogProgressViewHandler implements IDialogProgressViewHandler
{
    @Override
    public void setTextMsg(DialogProgressView dialogView, String text)
    {

    }

    @Override
    public int getContentViewResId(DialogProgressView dialogView)
    {
        return 0;
    }

    @Override
    public void onContentViewChanged(DialogProgressView dialogView)
    {

    }

    @Override
    public void onAttachedToWindow(DialogProgressView dialogView)
    {
        dialogView.setTextMsg("hook msg");
    }

    @Override
    public void onDetachedFromWindow(DialogProgressView dialogView)
    {

    }
}
