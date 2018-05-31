package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

/**
 * 底部滑入底部滑出
 */
public class SlideBotBotCreater implements DialogView.AnimatorCreater
{
    @Override
    public Animator createAnimator(boolean show, View view)
    {
        final ObjectAnimator animator = new ObjectAnimator();
        animator.setPropertyName(View.TRANSLATION_Y.getName());
        animator.setFloatValues(show ? new float[]{view.getHeight(), 0} : new float[]{0, view.getHeight()});
        animator.setTarget(view);
        return animator;
    }
}
