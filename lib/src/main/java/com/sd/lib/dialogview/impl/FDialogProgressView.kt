package com.sd.lib.dialogview.impl

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.sd.lib.dialog.IDialog
import com.sd.lib.dialogview.DialogProgressView
import com.sd.lib.dialogview.LibUtils
import com.sd.lib.dialogview.R
import com.sd.lib.dialogview.core.DialogViewManager
import com.sd.lib.dialogview.core.handler.IDialogProgressViewHandler

/**
 * 带环形进度条，和信息提示
 */
open class FDialogProgressView : BaseDialogView, DialogProgressView {
    @JvmField
    var tv_msg: TextView? = null

    @JvmField
    var pb_progress: ProgressBar? = null

    private var _consumeTouchEvent = false
    private val _handler: IDialogProgressViewHandler?

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        var layoutId = R.layout.lib_dialogview_progress_view

        _handler = DialogViewManager.dialogViewHandlerFactory.newProgressViewHandler(this)
        _handler?.let {
            val id = it.getContentViewResId(this)
            if (id != 0) {
                layoutId = id
            }
        }

        setContentView(layoutId)

        if (layoutParams == null) {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
        }
    }

    override fun onContentViewChanged() {
        tv_msg = findViewById(R.id.tv_msg)
        pb_progress = findViewById(R.id.pb_progress)
        _handler?.onContentViewChanged(this)
    }

    override fun initDialog(dialog: IDialog) {
        super.initDialog(dialog)
        dialog.setPadding(0, 0, 0, 0)
        dialog.gravity = Gravity.CENTER
    }

    override fun setConsumeTouchEvent(consume: Boolean): DialogProgressView {
        _consumeTouchEvent = consume
        return this
    }

    override fun setTextMsg(text: String?): DialogProgressView {
        LibUtils.setTextAndVisibility(text, tv_msg)
        _handler?.setTextMsg(this, text)
        return this
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (_consumeTouchEvent) {
            super.onTouchEvent(event)
            return true
        }
        return super.onTouchEvent(event)
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