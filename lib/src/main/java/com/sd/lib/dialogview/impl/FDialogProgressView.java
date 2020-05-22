package com.sd.lib.dialogview.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sd.lib.dialoger.Dialoger;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.R;
import com.sd.lib.dialogview.core.DialogViewManager;
import com.sd.lib.dialogview.core.handler.IProgressViewHandler;

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

        int layoutId = R.layout.lib_dialogview_view_progress;

        final IProgressViewHandler handler = DialogViewManager.getInstance().getProgressViewHandler();
        if (handler != null)
        {
            final int id = handler.getContentView(this);
            if (id != 0)
                layoutId = id;
        }

        setContentView(layoutId);
        if (getLayoutParams() == null)
        {
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    protected void onContentViewChanged()
    {
        super.onContentViewChanged();
        tv_msg = findViewById(R.id.tv_msg);
        pb_progress = findViewById(R.id.pb_progress);

        final IProgressViewHandler handler = DialogViewManager.getInstance().getProgressViewHandler();
        if (handler != null)
            handler.onContentViewChanged(this);
    }

    @Override
    protected void initDialog(Dialoger dialog)
    {
        super.initDialog(dialog);
        dialog.setPadding(0, 0, 0, 0);
        dialog.setGravity(Gravity.CENTER);
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

        final IProgressViewHandler handler = DialogViewManager.getInstance().getProgressViewHandler();
        if (handler != null)
            handler.setTextMsg(this, text);

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

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        final IProgressViewHandler handler = DialogViewManager.getInstance().getProgressViewHandler();
        if (handler != null)
            handler.onAttachedToWindow(this);
    }

    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        final IProgressViewHandler handler = DialogViewManager.getInstance().getProgressViewHandler();
        if (handler != null)
            handler.onDetachedFromWindow(this);
    }
}
