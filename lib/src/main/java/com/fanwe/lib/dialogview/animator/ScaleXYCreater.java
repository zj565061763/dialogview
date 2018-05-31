package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

public class ScaleXYCreater implements DialogView.AnimatorCreater
{
    private AnimatorSet mShowAnimator;
    private AnimatorSet mHideAnimator;

    public AnimatorSet getShowAnimator()
    {
        if (mShowAnimator == null)
        {
            mShowAnimator = new AnimatorSet();
            final ObjectAnimator[] animators = getObjectAnimator(0, 1.0f);
            mShowAnimator.play(animators[0]).with(animators[1]);
        }
        return mShowAnimator;
    }

    public AnimatorSet getHideAnimator()
    {
        if (mHideAnimator == null)
        {
            mHideAnimator = new AnimatorSet();
            final ObjectAnimator[] animators = getObjectAnimator(1.0f, 0);
            mHideAnimator.play(animators[0]).with(animators[1]);
        }
        return mHideAnimator;
    }

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
    public Animator createShowAnimator(DialogView dialogView)
    {
        final View contentView = dialogView.getContentView();
        if (contentView == null)
            return null;

        final AnimatorSet animatorSet = getShowAnimator();
        animatorSet.setTarget(contentView);
        return animatorSet;
    }

    @Override
    public Animator createHideAnimator(DialogView dialogView)
    {
        final View contentView = dialogView.getContentView();
        if (contentView == null)
            return null;

        final AnimatorSet animatorSet = getHideAnimator();
        animatorSet.setTarget(contentView);
        return animatorSet;
    }
}
