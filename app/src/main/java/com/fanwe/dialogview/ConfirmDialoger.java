package com.fanwe.dialogview;

import android.app.Activity;
import android.view.View;

import com.fanwe.lib.dialoger.impl.FDialoger;
import com.fanwe.lib.dialogview.ConfirmView;
import com.fanwe.lib.dialogview.impl.FConfirmView;

public class ConfirmDialoger extends FDialoger
{
    private ConfirmView mConfirmView;

    public ConfirmDialoger(Activity activity)
    {
        super(activity);
        setContentView((View) getConfirmView());
    }

    public ConfirmView getConfirmView()
    {
        if (mConfirmView == null)
            mConfirmView = new FConfirmView(getContext());
        return mConfirmView;
    }
}
