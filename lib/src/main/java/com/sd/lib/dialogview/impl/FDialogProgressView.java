package com.sd.lib.dialogview.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.R;

/**
 * 带环形进度条，和信息提示
 */
public class FDialogProgressView extends BaseDialogView implements DialogProgressView
{
    public TextView tv_msg;
    public ProgressBar pb_progress;

    public FDialogProgressView(Activity activity)
    {
        super(activity);

        setContentView(R.layout.lib_dialogview_view_progress);
        tv_msg = findViewById(R.id.tv_msg);
        pb_progress = findViewById(R.id.pb_progress);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public DialogProgressView setTextMsg(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_msg.setVisibility(View.GONE);
        } else
        {
            tv_msg.setVisibility(View.VISIBLE);
            tv_msg.setText(text);
        }
        return this;
    }
}
