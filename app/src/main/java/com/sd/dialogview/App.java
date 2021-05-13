package com.sd.dialogview;

import android.app.Application;

import com.sd.dialogview.handler.AppDialogConfirmViewHandler;
import com.sd.dialogview.handler.AppDialogMenuViewHandler;
import com.sd.dialogview.handler.AppDialogProgressViewHandler;
import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.core.DialogViewManager;
import com.sd.lib.dialogview.core.IDialogViewHandlerFactory;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler;
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DialogViewManager.INSTANCE.setDialogViewHandlerFactory(new IDialogViewHandlerFactory() {
            @Override
            public IDialogProgressViewHandler newProgressViewHandler(DialogProgressView dialogView) {
                return new AppDialogProgressViewHandler();
            }

            @Override
            public IDialogConfirmViewHandler newConfirmViewHandler(DialogConfirmView dialogView) {
                return new AppDialogConfirmViewHandler();
            }

            @Override
            public IDialogMenuViewHandler newMenuViewHandler(DialogMenuView dialogView) {
                return new AppDialogMenuViewHandler();
            }
        });
    }
}