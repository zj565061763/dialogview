package com.sd.lib.dialogview;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;

public interface DialogMenuView extends DialogView
{
    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    DialogMenuView setTextTitle(String text);

    /**
     * 设置取消文字
     *
     * @param text
     * @return
     */
    DialogMenuView setTextCancel(String text);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    DialogMenuView setCallback(Callback callback);

    /**
     * 设置列表数据
     *
     * @param objects
     * @return
     */
    DialogMenuView setItems(Object... objects);

    /**
     * 设置列表数据
     *
     * @param listObject
     * @return
     */
    DialogMenuView setItems(List<Object> listObject);

    /**
     * 设置适配器
     *
     * @param adapter
     * @return
     */
    DialogMenuView setAdapter(BaseAdapter adapter);

    abstract class Callback
    {
        /**
         * item项被点击
         *
         * @param v
         * @param index
         * @param view
         */
        public void onClickItem(View v, int index, DialogMenuView view)
        {
            view.getDialoger().dismiss();
        }

        /**
         * 取消按钮被点击
         *
         * @param v
         * @param view
         */
        public void onClickCancel(View v, DialogMenuView view)
        {
            view.getDialoger().dismiss();
        }
    }
}
