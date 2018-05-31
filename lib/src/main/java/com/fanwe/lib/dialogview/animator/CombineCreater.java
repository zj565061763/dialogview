package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

public abstract class CombineCreater implements DialogView.AnimatorCreater
{
    private Animator getAnimator(boolean show, View view, DialogView.AnimatorCreater[] creaters)
    {
        if (creaters == null || creaters.length <= 0)
            return null;

        final AnimatorSet animatorSet = new AnimatorSet();

        Animator mLast = null;
        for (int i = 0; i < creaters.length; i++)
        {
            final Animator animator = creaters[i].createAnimator(show, view);
            if (animator == null)
                continue;

            if (mLast == null)
                animatorSet.play(animator);
            else
                animatorSet.play(mLast).with(animator);

            mLast = animator;
        }

        if (mLast == null)
            return null;

        return animatorSet;
    }

    @Override
    public final Animator createAnimator(boolean show, View view)
    {
        final Animator animator = getAnimator(show, view, getCreaters());
        if (animator == null)
            return null;

        animator.setTarget(view);
        return animator;
    }

    protected abstract DialogView.AnimatorCreater[] getCreaters();
}
