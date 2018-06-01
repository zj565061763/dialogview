package com.fanwe.lib.dialogview.utils;

import android.animation.Animator;

public final class VisibilityAnimatorHandler
{
    private Animator mShowAnimator;
    private Animator mHideAnimator;

    private final AnimatorListenerWrapper mShowAnimatorListener = new AnimatorListenerWrapper();
    private final AnimatorListenerWrapper mHideAnimatorListener = new AnimatorListenerWrapper();

    /**
     * 设置显示动画
     *
     * @param animator
     */
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

    /**
     * 设置显示动画监听
     *
     * @param listener
     */
    public void setShowAnimatorListener(Animator.AnimatorListener listener)
    {
        mShowAnimatorListener.setOriginal(listener);
    }

    /**
     * 开始显示动画
     *
     * @return true-动画被执行
     */
    public boolean startShowAnimator()
    {
        if (mShowAnimator != null)
        {
            if (mShowAnimator.isStarted())
                return true;

            if (mHideAnimator != null)
                mHideAnimator.cancel();

            mShowAnimator.start();
            return true;
        }
        return false;
    }

    /**
     * 设置隐藏动画
     *
     * @param animator
     */
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

    /**
     * 设置隐藏动画监听
     *
     * @param listener
     */
    public void setHideAnimatorListener(Animator.AnimatorListener listener)
    {
        mHideAnimatorListener.setOriginal(listener);
    }

    /**
     * 开始隐藏动画
     *
     * @return true-动画被执行
     */
    public boolean startHideAnimator()
    {
        if (mHideAnimator != null)
        {
            if (mHideAnimator.isStarted())
                return true;

            if (mShowAnimator != null)
                mShowAnimator.cancel();

            mHideAnimator.start();
            return true;
        }
        return false;
    }

    public void cancelAnimators()
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
