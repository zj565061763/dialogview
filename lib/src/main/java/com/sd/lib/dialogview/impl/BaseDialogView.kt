package com.sd.lib.dialogview.impl

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.sd.lib.dialog.IDialog
import com.sd.lib.dialog.impl.FDialog
import com.sd.lib.dialoger.Dialoger
import com.sd.lib.dialoger.impl.FDialoger
import com.sd.lib.dialogview.DialogView

abstract class BaseDialogView : FrameLayout, DialogView, View.OnClickListener {
    private var _dialoger: Dialoger? = null
    private var _dialogv: IDialog? = null

    override val dialoger: Dialoger by lazy {
        FDialoger(context as Activity).also {
            _dialoger = it
            it.setContentView(this@BaseDialogView)
            initDialog(it)
        }
    }

    override val dialogv: IDialog by lazy {
        FDialog(context as Activity).also {
            _dialogv = it
            it.setContentView(this@BaseDialogView)
            initDialog(it)
        }
    }

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs)

    /**
     * 设置内容View布局id
     */
    fun setContentView(layoutId: Int) {
        val view = if (layoutId != 0) {
            LayoutInflater.from(context).inflate(layoutId, this, false)
        } else {
            null
        }
        setContentView(view)
    }

    /**
     * 设置内容View
     */
    fun setContentView(view: View?) {
        removeAllViews()
        if (view != null) {
            addView(view)
        }
        onContentViewChanged()
    }

    override fun onClick(v: View) {}

    /**
     * 内容View变化
     */
    protected abstract fun onContentViewChanged()

    /**
     * 初始化[Dialoger]
     */
    @Deprecated("see initDialogv")
    protected open fun initDialog(dialog: Dialoger) {
        dialog.setCanceledOnTouchOutside(false)
    }

    /**
     * 初始化[IDialog]
     */
    protected open fun initDialog(dialog: IDialog) {
        dialog.setCanceledOnTouchOutside(false)
    }

    override fun dismiss() {
        if (_dialoger != null || _dialogv != null) {
            _dialoger?.dismiss()
            _dialogv?.dismiss()
        } else {
            val viewParent = parent
            if (viewParent is ViewGroup) {
                try {
                    viewParent.removeView(this)
                } catch (e: Exception) {
                }
            }
        }
    }
}