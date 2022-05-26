package com.sd.lib.dialogview.impl

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.sd.lib.dialog.IDialog
import com.sd.lib.dialogview.DialogConfirmView
import com.sd.lib.dialogview.LibUtils
import com.sd.lib.dialogview.R
import com.sd.lib.dialogview.core.DialogViewManager.dialogViewHandlerFactory
import com.sd.lib.dialogview.core.handler.IDialogConfirmViewHandler

/**
 * 带标题，内容，确定按钮和取消按钮
 */
open class FDialogConfirmView : BaseDialogView, DialogConfirmView {
    @JvmField
    var tv_title: TextView? = null

    @JvmField
    var fl_content: FrameLayout? = null

    @JvmField
    var tv_content: TextView? = null

    @JvmField
    var tv_content_sub: TextView? = null

    @JvmField
    var tv_confirm: TextView? = null

    @JvmField
    var tv_cancel: TextView? = null

    private val _handler: IDialogConfirmViewHandler?
    private var _callback: DialogConfirmView.Callback? = null

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        var layoutId = R.layout.lib_dialogview_confirm_view

        _handler = dialogViewHandlerFactory.newConfirmViewHandler(this)
        _handler?.let {
            val id = it.getContentViewResId(this)
            if (id != 0) {
                layoutId = id
            }
        }

        setContentView(layoutId)

        if (layoutParams == null) {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
        }
    }

    override fun onContentViewChanged() {
        tv_title = findViewById(R.id.tv_title)
        fl_content = findViewById(R.id.fl_content)
        tv_content = findViewById(R.id.tv_content)
        tv_content_sub = findViewById(R.id.tv_content_sub)
        tv_confirm = findViewById(R.id.tv_confirm)
        tv_cancel = findViewById(R.id.tv_cancel)

        tv_confirm?.setOnClickListener(this)
        tv_cancel?.setOnClickListener(this)

        _handler?.onContentViewChanged(this)
    }

    override fun initDialog(dialog: IDialog) {
        super.initDialog(dialog)
        val defaultPadding = (context.resources.displayMetrics.widthPixels * 0.1f).toInt()
        dialog.setPadding(defaultPadding, defaultPadding, defaultPadding, defaultPadding)
        dialog.gravity = Gravity.CENTER
    }

    override fun setCallback(callback: DialogConfirmView.Callback?): DialogConfirmView {
        _callback = callback
        return this
    }

    override fun setTextTitle(text: String?): DialogConfirmView {
        LibUtils.setTextAndVisibility(text, tv_title)
        return this
    }

    override fun setTextContent(text: String?): DialogConfirmView {
        LibUtils.setTextAndVisibility(text, tv_content)
        return this
    }

    override fun setTextContentSub(text: String?): DialogConfirmView {
        LibUtils.setTextAndVisibility(text, tv_content_sub)
        return this
    }

    override fun setTextConfirm(text: String?): DialogConfirmView {
        LibUtils.setTextAndVisibility(text, tv_confirm)
        return this
    }

    override fun setTextCancel(text: String?): DialogConfirmView {
        LibUtils.setTextAndVisibility(text, tv_cancel)
        return this
    }

    override fun setTextColorTitle(color: Int): DialogConfirmView {
        tv_title?.setTextColor(color)
        return this
    }

    override fun setTextColorContent(color: Int): DialogConfirmView {
        tv_content?.setTextColor(color)
        return this
    }

    override fun setTextColorContentSub(color: Int): DialogConfirmView {
        tv_content_sub?.setTextColor(color)
        return this
    }

    override fun setTextColorConfirm(color: Int): DialogConfirmView {
        tv_confirm?.setTextColor(color)
        return this
    }

    override fun setTextColorCancel(color: Int): DialogConfirmView {
        tv_cancel?.setTextColor(color)
        return this
    }

    override fun setCustomView(layoutId: Int): DialogConfirmView {
        fl_content?.let {
            it.removeAllViews()
            LayoutInflater.from(context).inflate(layoutId, it, true)
        }
        return this
    }

    override fun setCustomView(view: View): DialogConfirmView {
        fl_content?.let {
            it.removeAllViews()
            it.addView(view)
        }
        return this
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v) {
            tv_confirm -> {
                val callback = _callback
                if (callback != null) {
                    callback.onClickConfirm(this)
                } else {
                    dismiss()
                }
            }
            tv_cancel -> {
                val callback = _callback
                if (callback != null) {
                    callback.onClickCancel(this)
                } else {
                    dismiss()
                }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        _handler?.onAttachedToWindow(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _handler?.onDetachedFromWindow(this)
    }
}