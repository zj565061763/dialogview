package com.sd.lib.dialogview.impl

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.sd.lib.dialoger.Dialoger
import com.sd.lib.dialoger.impl.FDialoger
import com.sd.lib.dialogview.DialogView

abstract class BaseDialogView : FrameLayout, DialogView, View.OnClickListener {
    private val _dialogLazy = lazy {
        FDialoger(context as Activity).apply {
            this.contentView = this@BaseDialogView
            initDialog(this)
        }
    }

    override val dialoger: Dialoger by _dialogLazy

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

    override fun onClick(v: View?) {}

    /**
     * 内容View变化
     */
    protected abstract fun onContentViewChanged()

    /**
     * 初始化[Dialoger]对象
     */
    protected open fun initDialog(dialog: Dialoger) {
        dialog.setCanceledOnTouchOutside(false)
    }

    override fun dismiss() {
        if (_dialogLazy.isInitialized()) {
            dialoger.dismiss()
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