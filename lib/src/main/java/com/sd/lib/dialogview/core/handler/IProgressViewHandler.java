package com.sd.lib.dialogview.core.handler;

import com.sd.lib.dialogview.DialogProgressView;

public interface IProgressViewHandler extends IDialogViewHandler<DialogProgressView>
{
    void setTextMsg(DialogProgressView dialogView, String text);
}
