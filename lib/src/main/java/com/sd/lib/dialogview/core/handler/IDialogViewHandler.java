package com.sd.lib.dialogview.core.handler;

import com.sd.lib.dialogview.DialogView;

public interface IDialogViewHandler<T extends DialogView>
{
    int getContentView(T dialogView);

    void onContentViewChanged(T dialogView);

    void onAttachedToWindow(T dialogView);

    void onDetachedFromWindow(T dialogView);
}
