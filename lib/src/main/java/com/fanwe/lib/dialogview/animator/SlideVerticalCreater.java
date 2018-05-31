package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

/**
 * 竖直方向滑动
 */
public abstract class SlideVerticalCreater implements DialogView.AnimatorCreater
{
    private ObjectAnimator getObjectAnimator(float... values)
    {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName(View.TRANSLATION_Y.getName());
        objectAnimator.setFloatValues(values);
        return objectAnimator;
    }

    @Override
    public Animator createAnimator(boolean show, View view)
    {
        final Animator animator = getObjectAnimator(getValues(show, view));
        animator.setTarget(view);
        return animator;
    }

    protected abstract float[] getValues(boolean show, View view);
}
