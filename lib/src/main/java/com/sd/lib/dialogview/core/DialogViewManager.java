package com.sd.lib.dialogview.core;

import com.sd.lib.dialogview.core.handler.IProgressViewHandler;

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

    private IProgressViewHandler mProgressViewHandler;

    private DialogViewManager()
    {
    }

    public IProgressViewHandler getProgressViewHandler()
    {
        return mProgressViewHandler;
    }

    public void setProgressViewHandler(IProgressViewHandler progressViewHandler)
    {
        mProgressViewHandler = progressViewHandler;
    }
}
