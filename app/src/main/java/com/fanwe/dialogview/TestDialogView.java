package com.fanwe.dialogview;

import android.app.Activity;

import com.fanwe.lib.dialoger.impl.FDialoger;

public class TestDialogView extends FDialoger
{
    public TestDialogView(Activity activity)
    {
        super(activity);
        setContentView(R.layout.dialog_view_test);
    }
}
