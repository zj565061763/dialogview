package com.sd.lib.dialogview.core.handler;

import com.sd.lib.dialogview.DialogView;

public interface IDialogViewHandler<T extends DialogView>
{
    /**
     * 返回内容布局id
     *
     * @param dialogView
     * @return
     */
    int getContentViewResId(T dialogView);

    /**
     * 内容view变化
     *
     * @param dialogView
     */
    void onContentViewChanged(T dialogView);

    void onAttachedToWindow(T dialogView);

    void onDetachedFromWindow(T dialogView);
}
