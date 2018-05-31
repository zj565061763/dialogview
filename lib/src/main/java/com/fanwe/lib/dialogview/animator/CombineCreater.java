package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

public abstract class CombineCreater implements DialogView.AnimatorCreater
{
    private Animator getAnimator(Animator[] animators)
    {
        if (animators == null || animators.length <= 0)
            return null;

        final AnimatorSet animatorSet = new AnimatorSet();

        Animator mlast = null;
        for (int i = 0; i < animators.length; i++)
        {
            final Animator animator = animators[i];
            if (animator == null)
                continue;

            if (mlast == null)
            {
                animatorSet.play(animator);
            } else
            {
                animatorSet.play(mlast).with(animator);
            }
            mlast = animator;
        }

        return animatorSet;
    }

    @Override
    public Animator createDialogViewAnimator(boolean show, View view)
    {
        final Animator animator = getAnimator(createDialogViewAnimators(show, view));
        if (animator == null)
            return null;

        animator.setTarget(view);
        return animator;
    }

    @Override
    public Animator createContentViewAnimator(boolean show, View view)
    {
        final Animator animator = getAnimator(createContentViewAnimators(show, view));
        if (animator == null)
            return null;

        animator.setTarget(view);
        return animator;
    }

    protected abstract Animator[] createDialogViewAnimators(boolean show, View view);

    protected abstract Animator[] createContentViewAnimators(boolean show, View view);
}
