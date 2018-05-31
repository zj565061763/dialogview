package com.fanwe.lib.dialogview.utils;

import android.animation.Animator;

public final class VisibilityAnimatorHandler
{
    private Animator mShowAnimator;
    private Animator mHideAnimator;

    private final AnimatorListenerWrapper mShowAnimatorListener = new AnimatorListenerWrapper();
    private final AnimatorListenerWrapper mHideAnimatorListener = new AnimatorListenerWrapper();

    public void setShowAnimator(Animator animator)
    {
        if (mShowAnimator != animator)
        {
            if (animator != null)
                animator.removeListener(mShowAnimatorListener);

            mShowAnimator = animator;

            if (mShowAnimator != null)
                mShowAnimator.addListener(mShowAnimatorListener);
        }
    }

    public boolean startShowAnimator(Animator.AnimatorListener listener)
    {
        cancelAnimator();

        if (mShowAnimator != null)
        {
            mShowAnimatorListener.setOriginal(listener);
            mShowAnimator.start();
            return true;
        }
        return false;
    }

    public void setHideAnimator(Animator animator)
    {
        if (mHideAnimator != animator)
        {
            if (animator != null)
                animator.removeListener(mHideAnimatorListener);

            mHideAnimator = animator;

            if (mHideAnimator != null)
                mHideAnimator.addListener(mHideAnimatorListener);
        }
    }

    public boolean startHideAnimator(Animator.AnimatorListener listener)
    {
        cancelAnimator();

        if (mHideAnimator != null)
        {
            mHideAnimatorListener.setOriginal(listener);
            mHideAnimator.start();
            return true;
        }
        return false;
    }

    public void cancelAnimator()
    {
        if (mShowAnimator != null)
            mShowAnimator.cancel();

        if (mHideAnimator != null)
            mHideAnimator.cancel();
    }

    private static class AnimatorListenerWrapper implements Animator.AnimatorListener
    {
        private Animator.AnimatorListener mOriginal;

        public void setOriginal(Animator.AnimatorListener original)
        {
            mOriginal = original;
        }

        @Override
        public void onAnimationStart(Animator animation)
        {
            if (mOriginal != null)
                mOriginal.onAnimationStart(animation);
        }

        @Override
        public void onAnimationEnd(Animator animation)
        {
            if (mOriginal != null)
                mOriginal.onAnimationEnd(animation);
        }

        @Override
        public void onAnimationCancel(Animator animation)
        {
            if (mOriginal != null)
                mOriginal.onAnimationCancel(animation);
        }

        @Override
        public void onAnimationRepeat(Animator animation)
        {
            if (mOriginal != null)
                mOriginal.onAnimationRepeat(animation);
        }
    }
}
