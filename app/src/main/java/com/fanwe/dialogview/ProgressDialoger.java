package com.fanwe.dialogview;

import android.app.Activity;

import com.fanwe.lib.dialoger.impl.FDialoger;
import com.fanwe.lib.dialogview.impl.FProgressView;

public class ProgressDialoger extends FDialoger
{
    private FProgressView mProgressView;

    public ProgressDialoger(Activity activity)
    {
        super(activity);
        setContentView(getProgressView());
    }

    public FProgressView getProgressView()
    {
        if (mProgressView == null)
            mProgressView = new FProgressView(getContext())
            {
                @Override
                public void dismiss()
                {
                    ProgressDialoger.this.dismiss();
                }
            };
        return mProgressView;
    }
}
