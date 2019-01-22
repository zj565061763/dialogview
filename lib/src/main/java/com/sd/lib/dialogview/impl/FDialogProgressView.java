package com.sd.lib.dialogview.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
    private boolean mConsumeTouchEvent;

    public FDialogProgressView(Context context)
    {
        this(context, null);
    }

    public FDialogProgressView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        setContentView(R.layout.lib_dialogview_view_progress);
        tv_msg = findViewById(R.id.tv_msg);
        pb_progress = findViewById(R.id.pb_progress);

        if (getLayoutParams() == null)
        {
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public DialogProgressView setConsumeTouchEvent(boolean consume)
    {
        mConsumeTouchEvent = consume;
        return this;
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

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (mConsumeTouchEvent)
        {
            super.onTouchEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }
}
