package com.sd.dialogview;

import android.app.Application;

import com.sd.dialogview.handler.AppDialogViewHandlerFactory;
import com.sd.lib.dialogview.core.DialogViewManager;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        DialogViewManager.getInstance().setDialogViewHandlerFactory(new AppDialogViewHandlerFactory());
    }
}
