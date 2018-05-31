package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

/**
 * 透明度
 */
public class AlphaCreater implements DialogView.AnimatorCreater
{
    private ObjectAnimator getObjectAnimator(float... values)
    {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName(View.ALPHA.getName());
        objectAnimator.setFloatValues(values);
        return objectAnimator;
    }

    @Override
    public Animator createAnimator(boolean show, View view)
    {
        final Animator animator = show ? getObjectAnimator(0, 1.0f) : getObjectAnimator(1.0f, 0);
        animator.setTarget(view);
        return animator;
    }
}
