package com.sd.dialogview;

import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.handler.IProgressViewHandler;
import com.sd.lib.dialogview.impl.FDialogProgressView;

public class AppProgressViewHandler implements IProgressViewHandler
{
    @Override
    public void setTextMsg(DialogProgressView dialogView, String text)
    {

    }

    @Override
    public int getContentView(DialogProgressView dialogView)
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
        dialogView.setTextMsg("hook");
    }

    @Override
    public void onDetachedFromWindow(DialogProgressView dialogView)
    {

    }
}
