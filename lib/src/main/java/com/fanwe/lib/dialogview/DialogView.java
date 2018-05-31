package com.fanwe.lib.dialogview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

public interface DialogView
{
    View getContentView();

    void setContentView(int layoutId);

    void setContentView(View view);

    void setContentView(View view, ViewGroup.LayoutParams params);

    void setGrativity(int gravity);

    void setCancelable(boolean cancel);

    void setCanceledOnTouchOutside(boolean cancel);

    void setOnDismissListener(OnDismissListener listener);

    void setAnimatorCreater(AnimatorCreater creater);

    void show();

    void dismiss();

    interface OnDismissListener
    {
        void onDismiss(DialogView dialogView);
    }

    interface AnimatorCreater
    {
        Animator createShowAnimator(DialogView dialogView);

        Animator createHideAnimator(DialogView dialogView);
    }
}
