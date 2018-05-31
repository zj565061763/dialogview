package com.fanwe.lib.dialogview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.fanwe.lib.dialogview.animator.AlphaCreater;
import com.fanwe.lib.dialogview.animator.ScaleXYCreater;
import com.fanwe.lib.dialogview.utils.VisibilityAnimatorHandler;

public class FDialogView extends FrameLayout implements DialogView
{
    private final Activity mActivity;
    private final ViewGroup mDialogParent;

    private View mContentView;
    private int mGravity = Gravity.CENTER;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;

    private OnDismissListener mOnDismissListener;
    private boolean mAttach;

    private VisibilityAnimatorHandler mAnimatorHandler;
    private AnimatorCreater mDialogAnimatorCreater;
    private AnimatorCreater mContentAnimatorCreater;
    private boolean mStartShowAnimator;

    public FDialogView(Activity activity)
    {
        super(activity);
        mActivity = activity;
        mDialogParent = activity.findViewById(android.R.id.content);
        setDialogAnimatorCreater(new AlphaCreater());
        setContentAnimatorCreater(new ScaleXYCreater());
    }

    @Override
    public final View getContentView()
    {
        return mContentView;
    }

    @Override
    public void setContentView(int layoutId)
    {
        final View view = LayoutInflater.from(getContext()).inflate(layoutId, this, false);
        setDialogView(view);
    }

    @Override
    public void setContentView(View view)
    {
        setDialogView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params)
    {
        view.setLayoutParams(params);
        setDialogView(view);
    }

    private void setDialogView(View view)
    {
        mContentView = view;

        final FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        p.gravity = mGravity;

        final ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null)
        {
            p.width = params.width;
            p.height = params.height;
        }

        removeAllViews();
        addView(view, p);

        onContentViewAdded(view);
    }

    protected void onContentViewAdded(View contentView)
    {
    }

    @Override
    public void setGrativity(int gravity)
    {
        mGravity = gravity;

        if (getContentView() != null)
        {
            final FrameLayout.LayoutParams params = (LayoutParams) getContentView().getLayoutParams();
            params.gravity = gravity;
            mContentView.setLayoutParams(params);
        }
    }

    @Override
    public void setCancelable(boolean cancel)
    {
        mCancelable = cancel;
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel)
    {
        if (cancel && !mCancelable)
            mCancelable = true;

        mCanceledOnTouchOutside = cancel;
    }

    @Override
    public void setOnDismissListener(OnDismissListener listener)
    {
        mOnDismissListener = listener;
    }


    @Override
    public void setDialogAnimatorCreater(AnimatorCreater creater)
    {
        mDialogAnimatorCreater = creater;
    }

    @Override
    public void setContentAnimatorCreater(AnimatorCreater creater)
    {
        mContentAnimatorCreater = creater;
    }

    @Override
    public void show()
    {
        if (mContentView != null)
            attach(true);
    }

    @Override
    public void dismiss()
    {
        attach(false);
    }

    private VisibilityAnimatorHandler getAnimatorHandler()
    {
        if (mAnimatorHandler == null)
            mAnimatorHandler = new VisibilityAnimatorHandler();
        return mAnimatorHandler;
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params)
    {
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        super.setLayoutParams(params);
    }

    private boolean isViewUnder(View view, int x, int y)
    {
        if (view == null)
            return false;

        return x >= view.getLeft() && x < view.getRight()
                && y >= view.getTop() && y < view.getBottom();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (!isViewUnder(mContentView, (int) event.getX(), (int) event.getY()))
        {
            if (mCanceledOnTouchOutside)
            {
                dismiss();
                return true;
            }
        }
        super.onTouchEvent(event);
        return true;
    }

    private void attach(boolean attach)
    {
        if (mAttach == attach)
            return;

        if (attach)
        {
            if (getParent() == null)
                mDialogParent.addView(this);
        } else
        {
            if (getParent() != null && !mActivity.isFinishing())
            {
                getAnimatorHandler().setHideAnimator(createAnimator(false));
                if (!getAnimatorHandler().startHideAnimator(mHideAnimatorListener))
                    removeSelf();
            }
        }

        mAttach = attach;
    }

    private boolean mRemoveByAnimator;
    private final Animator.AnimatorListener mHideAnimatorListener = new AnimatorListenerAdapter()
    {
        @Override
        public void onAnimationEnd(Animator animation)
        {
            super.onAnimationEnd(animation);
            mRemoveByAnimator = true;
            removeSelf();
        }
    };

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);

        if (mStartShowAnimator)
        {
            getAnimatorHandler().setShowAnimator(createAnimator(true));
            getAnimatorHandler().startShowAnimator(null);
            mStartShowAnimator = false;
        }
    }

    private Animator createAnimator(boolean show)
    {
        Animator animator = null;

        final Animator dialogAnimator = mDialogAnimatorCreater != null ?
                mDialogAnimatorCreater.createAnimator(show, this) : null;

        final Animator contentAnimator = (mContentAnimatorCreater != null && getContentView() != null) ?
                mContentAnimatorCreater.createAnimator(show, getContentView()) : null;

        if (dialogAnimator != null && contentAnimator != null)
        {
            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(dialogAnimator).with(contentAnimator);
            animator = animatorSet;
        } else if (dialogAnimator != null)
        {
            animator = dialogAnimator;
        } else if (contentAnimator != null)
        {
            animator = contentAnimator;
        }
        return animator;
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (getParent() != mDialogParent)
            throw new RuntimeException("dialog view can not be add to:" + getParent());

        mStartShowAnimator = true;
    }

    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mAttach && !mActivity.isFinishing())
            throw new RuntimeException("you must call dismiss() method to remove dialog view");

        mStartShowAnimator = false;
        if (!mRemoveByAnimator)
            getAnimatorHandler().cancelAnimator();

        if (mOnDismissListener != null)
            mOnDismissListener.onDismiss(this);
    }

    private void removeSelf()
    {
        try
        {
            final ViewParent parent = getParent();
            if (parent instanceof ViewGroup)
                ((ViewGroup) parent).removeView(this);
        } catch (Exception e)
        {
        } finally
        {
            mRemoveByAnimator = false;
        }
    }
}
