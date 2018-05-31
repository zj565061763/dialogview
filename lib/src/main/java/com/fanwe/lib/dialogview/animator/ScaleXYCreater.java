package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

/**
 * 缩放
 */
public class ScaleXYCreater implements DialogView.AnimatorCreater
{
    private ObjectAnimator[] getObjectAnimator(float... values)
    {
        final ObjectAnimator[] animators = new ObjectAnimator[2];

        final ObjectAnimator scaleX = new ObjectAnimator();
        scaleX.setPropertyName(View.SCALE_X.getName());
        scaleX.setFloatValues(values);

        final ObjectAnimator scaleY = new ObjectAnimator();
        scaleY.setPropertyName(View.SCALE_Y.getName());
        scaleY.setFloatValues(values);

        animators[0] = scaleX;
        animators[1] = scaleY;
        return animators;
    }

    @Override
    public Animator createDialogViewAnimator(boolean show, View view)
    {
        final ObjectAnimator[] animators = show ? getObjectAnimator(0, 1.0f) : getObjectAnimator(1.0f, 0);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animators[0]).with(animators[1]);
        animatorSet.setTarget(view);
        return animatorSet;
    }

    @Override
    public Animator createContentViewAnimator(boolean show, View view)
    {
        return createDialogViewAnimator(show, view);
    }
}
