package com.sd.lib.dialogview.core;

import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler;
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
    private IDialogMenuViewHandler mMenuViewHandler;

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

    public IDialogMenuViewHandler getMenuViewHandler()
    {
        return mMenuViewHandler;
    }

    public void setMenuViewHandler(IDialogMenuViewHandler menuViewHandler)
    {
        mMenuViewHandler = menuViewHandler;
    }
}