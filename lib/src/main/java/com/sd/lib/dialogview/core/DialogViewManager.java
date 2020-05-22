package com.sd.lib.dialogview.core;

import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;
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

    private IDialogViewHandlerFactory mDialogViewHandlerFactory;

    private DialogViewManager()
    {
    }

    public void setDialogViewHandlerFactory(IDialogViewHandlerFactory factory)
    {
        mDialogViewHandlerFactory = factory;
    }

    public IDialogViewHandlerFactory getDialogViewHandlerFactory()
    {
        if (mDialogViewHandlerFactory == null)
        {
            mDialogViewHandlerFactory = new IDialogViewHandlerFactory()
            {
                @Override
                public IDialogProgressViewHandler newProgressViewHandler(DialogProgressView dialogView)
                {
                    return null;
                }

                @Override
                public IDialogConfirmViewHandler newConfirmViewHandler(DialogConfirmView dialogView)
                {
                    return null;
                }

                @Override
                public IDialogMenuViewHandler newMenuViewHandler(DialogMenuView dialogView)
                {
                    return null;
                }
            };
        }
        return mDialogViewHandlerFactory;
    }
}
