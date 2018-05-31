package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

/**
 * 底部滑入滑出
 */
public class SlideBotBotCreater implements DialogView.AnimatorCreater
{
    private ObjectAnimator getObjectAnimator(float... values)
    {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName(View.TRANSLATION_Y.getName());
        objectAnimator.setFloatValues(values);
        return objectAnimator;
    }

    @Override
    public Animator createDialogViewAnimator(boolean show, View view)
    {
        final Animator animator = show ?
                getObjectAnimator(view.getHeight(), 0) : getObjectAnimator(0, view.getHeight());
        animator.setTarget(view);
        return animator;
    }

    @Override
    public Animator createContentViewAnimator(boolean show, View view)
    {
        return createDialogViewAnimator(show, view);
    }
}
