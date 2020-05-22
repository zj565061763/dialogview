package com.sd.dialogview;

import android.app.Application;

import com.sd.dialogview.handler.AppDialogConfirmViewHandler;
import com.sd.dialogview.handler.AppDialogMenuViewHandler;
import com.sd.dialogview.handler.AppDialogProgressViewHandler;
import com.sd.lib.dialogview.core.DialogViewManager;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        DialogViewManager.getInstance().setProgressViewHandler(new AppDialogProgressViewHandler());
        DialogViewManager.getInstance().setConfirmViewHandler(new AppDialogConfirmViewHandler());
        DialogViewManager.getInstance().setMenuViewHandler(new AppDialogMenuViewHandler());
    }
}
