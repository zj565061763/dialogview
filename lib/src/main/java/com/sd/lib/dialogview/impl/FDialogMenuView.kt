package com.sd.lib.dialogview.impl

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.sd.lib.dialog.IDialog
import com.sd.lib.dialoger.Dialoger
import com.sd.lib.dialogview.DialogMenuView
import com.sd.lib.dialogview.LibUtils
import com.sd.lib.dialogview.R
import com.sd.lib.dialogview.core.DialogViewManager.dialogViewHandlerFactory
import com.sd.lib.dialogview.core.handler.IDialogMenuViewHandler
import java.util.*

/**
 * 带取消按钮的菜单
 */
open class FDialogMenuView : BaseDialogView, DialogMenuView {
    @JvmField
    var tv_title: TextView? = null

    @JvmField
    var tv_cancel: TextView? = null

    @JvmField
    var lv_content: ListView? = null

    private var _listModel: List<Any>? = null
    private val _handler: IDialogMenuViewHandler?
    private var _callback: DialogMenuView.Callback? = null

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        var layoutId = R.layout.lib_dialogview_menu_view

        _handler = dialogViewHandlerFactory.newMenuViewHandler(this)
        _handler?.let {
            val id = it.getContentViewResId(this)
            if (id != 0) {
                layoutId = id
            }
        }

        setContentView(layoutId)

        setTextTitle(null)
        if (layoutParams == null) {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onContentViewChanged() {
        tv_title = findViewById(R.id.tv_title)
        tv_cancel = findViewById(R.id.tv_cancel)
        lv_content = findViewById(R.id.lv_content)

        tv_cancel?.setOnClickListener(this)
        setAdapter(_defaultAdapter)

        _handler?.onContentViewChanged(this)
    }

    override fun initDialog(dialog: Dialoger) {
        super.initDialog(dialog)
        dialog.setPadding(0, 0, 0, 0)
        dialog.gravity = Gravity.BOTTOM
        dialog.setCanceledOnTouchOutside(true)
    }

    override fun initDialogv(dialog: IDialog) {
        super.initDialogv(dialog)
        dialog.setPadding(0, 0, 0, 0)
        dialog.gravity = Gravity.BOTTOM
        dialog.setCanceledOnTouchOutside(true)
    }

    override fun setCallback(callback: DialogMenuView.Callback?): DialogMenuView {
        _callback = callback
        return this
    }

    override fun setTextTitle(text: String?): DialogMenuView {
        LibUtils.setTextAndVisibility(text, tv_title)
        return this
    }

    override fun setTextCancel(text: String?): DialogMenuView {
        LibUtils.setTextAndVisibility(text, tv_cancel)
        return this
    }

    override fun setItems(vararg objects: Any): DialogMenuView {
        setItemList(objects.toList())
        return this
    }

    override fun setItemList(listObject: List<Any>): DialogMenuView {
        _listModel = listObject
        _defaultAdapter.notifyDataSetChanged()
        return this
    }

    override fun setAdapter(adapter: BaseAdapter?): DialogMenuView {
        lv_content?.let {
            it.adapter = adapter ?: _defaultAdapter
            it.onItemClickListener = OnItemClickListener { parent, view, position, id ->
                val callback = _callback
                if (callback != null) {
                    callback.onClickItem(view, id.toInt(), this@FDialogMenuView)
                    callback.onClickItem(id.toInt(), this@FDialogMenuView)
                } else {
                    dismiss()
                }
            }
        }
        return this
    }

    /**
     * 默认适配器
     */
    private val _defaultAdapter = object : BaseAdapter() {
        override fun getCount(): Int {
            return _listModel?.size ?: 0
        }

        override fun getItem(position: Int): Any {
            return getModel(position)!!
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var view = convertView
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.lib_dialogview_menu_item_view, parent, false)!!
            }

            val textView = view.findViewById<TextView>(R.id.tv_content)
            val model = getModel(position)

            if (textView != null && model != null) {
                textView.text = if (model is DialogMenuView.Item) {
                    model.getItemDisplayContent()
                } else {
                    model.toString()
                }
            }

            return view
        }
    }

    private fun getModel(position: Int): Any? {
        val list = _listModel ?: return null
        return list.getOrNull(position)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v) {
            tv_cancel -> {
                val callback = _callback
                if (callback != null) {
                    callback.onClickCancel(v!!, this)
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

    override fun setItems(listObject: List<Any>): DialogMenuView {
        setItemList(listObject)
        return this
    }
}