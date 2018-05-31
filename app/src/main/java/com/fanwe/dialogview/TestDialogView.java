package com.fanwe.dialogview;

import android.app.Activity;

import com.fanwe.lib.dialogview.FDialogView;

public class TestDialogView extends FDialogView
{
    public TestDialogView(Activity activity)
    {
        super(activity);
        setContentView(R.layout.dialog_view_test);
    }
}
