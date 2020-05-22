package com.sd.lib.dialogview.core;

import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler;

public class DialogViewManager
{
    private static DialogViewManager sInstance;

    public static DialogViewManager getInstance()
    {
        if (sInstance == null)
        {
            synchronized (DialogViewManager.class)
            {
                if (sInstance == null)
                    sInstance = new DialogViewManager();
            }
        }
        return sInstance;
    }

    private IDialogProgressViewHandler mProgressViewHandler;

    private DialogViewManager()
    {
    }

    public IDialogProgressViewHandler getProgressViewHandler()
    {
        return mProgressViewHandler;
    }

    public void setProgressViewHandler(IDialogProgressViewHandler progressViewHandler)
    {
        mProgressViewHandler = progressViewHandler;
    }
}
