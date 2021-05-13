package com.sd.lib.dialogview.impl;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.sd.lib.dialoger.Dialoger;
import com.sd.lib.dialoger.impl.FDialoger;
import com.sd.lib.dialogview.DialogView;

public class BaseDialogView extends FrameLayout implements DialogView, View.OnClickListener
{
    private Dialoger mDialoger;

    public BaseDialogView(Context context)
    {
        this(context, null);
    }

    public BaseDialogView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setContentView(int layoutId)
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
        onContentViewChanged();
    }

    public void setContentView(View view)
    {
        removeAllViews();
        addView(view);
        onContentViewChanged();
    }

    protected void onContentViewChanged()
    {

    }

    @Override
    public void onClick(View v)
    {

    }

    @Override
    public Dialoger getDialoger()
    {
        if (mDialoger == null)
        {
            mDialoger = new FDialoger((Activity) getContext());
            mDialoger.setContentView(this);
            initDialog(mDialoger);
        }
        return mDialoger;
    }

    protected void initDialog(Dialoger dialog)
    {
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void dismiss()
    {
        if (mDialoger != null)
        {
            mDialoger.dismiss();
        } else
        {
            final ViewParent parent = getParent();
            if (parent instanceof ViewGroup)
            {
                try
                {
                    ((ViewGroup) parent).removeView(this);
                } catch (Exception e)
                {
                }
            }
        }
    }
}
