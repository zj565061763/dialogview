package com.sd.lib.dialogview.impl;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sd.lib.dialogview.DialogView;
import com.sd.lib.dialoger.Dialoger;
import com.sd.lib.dialoger.impl.FDialoger;

public class BaseDialogView extends FrameLayout implements DialogView, View.OnClickListener
{
    private Dialoger mDialoger;

    public BaseDialogView(Activity activity)
    {
        super(activity);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void setContentView(int layoutId)
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
    }

    public void setContentView(View view)
    {
        removeAllViews();
        addView(view);
    }

    @Override
    public void onClick(View v)
    {

    }

    protected static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (view == null)
        {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override
    public Dialoger getDialoger()
    {
        if (mDialoger == null)
        {
            mDialoger = new FDialoger((Activity) getContext());
            mDialoger.setContentView(this);
            mDialoger.setCanceledOnTouchOutside(false);
        }
        return mDialoger;
    }
}
