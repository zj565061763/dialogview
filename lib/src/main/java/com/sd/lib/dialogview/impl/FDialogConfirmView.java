package com.sd.lib.dialogview.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sd.lib.dialoger.Dialoger;
import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.R;
import com.sd.lib.dialogview.core.DialogViewManager;
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler;

/**
 * 带标题，内容，确定按钮和取消按钮
 */
public class FDialogConfirmView extends BaseDialogView implements DialogConfirmView
{
    public TextView tv_title;

    public FrameLayout fl_content;
    public TextView tv_content;
    public TextView tv_content_sub;

    public TextView tv_confirm;
    public TextView tv_cancel;

    private Callback mCallback;

    private final IDialogConfirmViewHandler mHandler;

    public FDialogConfirmView(Context context)
    {
        this(context, null);
    }

    public FDialogConfirmView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mHandler = DialogViewManager.getInstance().getDialogViewHandlerFactory().newConfirmViewHandler(this);

        int layoutId = R.layout.lib_dialogview_confirm_view;
        if (mHandler != null)
        {
            final int id = mHandler.getContentView(this);
            if (id != 0)
                layoutId = id;
        }

        setContentView(layoutId);

        if (getLayoutParams() == null)
        {
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    protected void onContentViewChanged()
    {
        super.onContentViewChanged();
        tv_title = findViewById(R.id.tv_title);
        fl_content = findViewById(R.id.fl_content);
        tv_content = findViewById(R.id.tv_content);
        tv_content_sub = findViewById(R.id.tv_content_sub);
        tv_confirm = findViewById(R.id.tv_confirm);
        tv_cancel = findViewById(R.id.tv_cancel);

        tv_confirm.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);

        if (mHandler != null)
            mHandler.onContentViewChanged(this);
    }

    @Override
    protected void initDialog(Dialoger dialog)
    {
        super.initDialog(dialog);
        final int defaultPadding = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.1f);
        dialog.setPadding(defaultPadding, 0, defaultPadding, 0);
        dialog.setGravity(Gravity.CENTER);
    }

    @Override
    public DialogConfirmView setCustomView(int layoutId)
    {
        fl_content.removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, fl_content, true);
        return this;
    }

    @Override
    public DialogConfirmView setCustomView(View view)
    {
        fl_content.removeAllViews();
        fl_content.addView(view);
        return this;
    }

    @Override
    public DialogConfirmView setCallback(Callback callback)
    {
        mCallback = callback;
        return this;
    }

    @Override
    public DialogConfirmView setTextTitle(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_title.setVisibility(View.GONE);
        } else
        {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirmView setTextContent(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_content.setVisibility(View.GONE);
        } else
        {
            tv_content.setVisibility(View.VISIBLE);
            tv_content.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirmView setTextContentSub(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_content_sub.setVisibility(View.GONE);
        } else
        {
            tv_content_sub.setVisibility(View.VISIBLE);
            tv_content_sub.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirmView setTextConfirm(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_confirm.setVisibility(View.GONE);
        } else
        {
            tv_confirm.setVisibility(View.VISIBLE);
            tv_confirm.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirmView setTextCancel(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_cancel.setVisibility(View.GONE);
        } else
        {
            tv_cancel.setVisibility(View.VISIBLE);
            tv_cancel.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirmView setTextColorTitle(int color)
    {
        tv_title.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirmView setTextColorContent(int color)
    {
        tv_content.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirmView setTextColorContentSub(int color)
    {
        tv_content_sub.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirmView setTextColorConfirm(int color)
    {
        tv_confirm.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirmView setTextColorCancel(int color)
    {
        tv_cancel.setTextColor(color);
        return this;
    }

    @Override
    public void onClick(View v)
    {
        super.onClick(v);
        if (v == tv_confirm)
        {
            if (mCallback != null)
                mCallback.onClickConfirm(v, this);
            else
                dismiss();
        } else if (v == tv_cancel)
        {
            if (mCallback != null)
                mCallback.onClickCancel(v, this);
            else
                dismiss();
        }
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mHandler != null)
            mHandler.onAttachedToWindow(this);
    }

    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mHandler != null)
            mHandler.onDetachedFromWindow(this);
    }
}
