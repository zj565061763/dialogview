package com.sd.dialogview;

import android.app.Application;

import com.sd.lib.dialogview.core.DialogViewManager;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        DialogViewManager.getInstance().setProgressViewHandler(new AppProgressViewHandler());
    }
}
