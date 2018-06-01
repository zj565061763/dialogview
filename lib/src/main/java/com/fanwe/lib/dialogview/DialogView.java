package com.fanwe.lib.dialogview;

import android.animation.Animator;
import android.view.View;

public interface DialogView
{
    View getContentView();

    void setContentView(int layoutId);

    void setContentView(View view);

    void setGrativity(int gravity);

    void setCancelable(boolean cancel);

    void setCanceledOnTouchOutside(boolean cancel);

    void setDialogAnimatorCreater(AnimatorCreater creater);

    void setContentAnimatorCreater(AnimatorCreater creater);

    void setOnDismissListener(OnDismissListener listener);

    void show();

    void dismiss();

    interface OnDismissListener
    {
        void onDismiss(DialogView dialogView);
    }

    interface AnimatorCreater
    {
        Animator createAnimator(boolean show, View view);
    }
}
