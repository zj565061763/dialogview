package com.fanwe.lib.dialogview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.fanwe.lib.dialogview.utils.ViewAnimatorHandler;

public class FDialogView extends FrameLayout implements DialogView
{
    private final ViewGroup mViewGroup;

    private View mContentView;
    private int mGravity = Gravity.CENTER;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;

    private boolean mAttach;

    private ViewAnimatorHandler mAnimatorHandler;

    public FDialogView(Activity activity)
    {
        super(activity);
        mViewGroup = activity.findViewById(android.R.id.content);
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
    public void setShowAnimator(Animator animator)
    {
        getAnimatorHandler().setShowAnimator(animator);
    }

    @Override
    public void setHideAnimator(Animator animator)
    {
        getAnimatorHandler().setHideAnimator(animator);
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

    private ViewAnimatorHandler getAnimatorHandler()
    {
        if (mAnimatorHandler == null)
            mAnimatorHandler = new ViewAnimatorHandler();
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
            if (getParent() != mViewGroup)
            {
                mViewGroup.addView(this);
            }
        } else
        {
            if (getParent() == mViewGroup)
            {
                if (!getAnimatorHandler().startHideAnimator(mHideAnimatorListener))
                    removeSelf();
            }
        }

        mAttach = attach;
    }

    private final Animator.AnimatorListener mHideAnimatorListener = new AnimatorListenerAdapter()
    {
        @Override
        public void onAnimationEnd(Animator animation)
        {
            super.onAnimationEnd(animation);
            post(new Runnable()
            {
                @Override
                public void run()
                {
                    removeSelf();
                }
            });
        }
    };

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getAnimatorHandler().startShowAnimator(null);
    }

    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        getAnimatorHandler().cancelAnimator();
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
        }
    }
}
