package com.sd.lib.dialogview;

import android.view.View;

public interface DialogConfirmView extends DialogView
{
    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param layoutId
     * @return
     */
    DialogConfirmView setCustomView(int layoutId);

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param view
     * @return
     */
    DialogConfirmView setCustomView(View view);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    DialogConfirmView setCallback(Callback callback);

    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    DialogConfirmView setTextTitle(String text);

    /**
     * 设置内容文字
     *
     * @param text
     * @return
     */
    DialogConfirmView setTextContent(String text);

    /**
     * 设置取消按钮文字
     *
     * @param text
     * @return
     */
    DialogConfirmView setTextCancel(String text);

    /**
     * 设置确定按钮文字
     *
     * @param text
     * @return
     */
    DialogConfirmView setTextConfirm(String text);

    /**
     * 设置标题文字颜色
     *
     * @param color
     * @return
     */
    DialogConfirmView setTextColorTitle(int color);

    /**
     * 设置内容文字颜色
     *
     * @param color
     * @return
     */
    DialogConfirmView setTextColorContent(int color);

    /**
     * 设置取消文字颜色
     *
     * @param color
     * @return
     */
    DialogConfirmView setTextColorCancel(int color);

    /**
     * 设置确认文字颜色
     *
     * @param color
     * @return
     */
    DialogConfirmView setTextColorConfirm(int color);

    abstract class Callback
    {
        /**
         * 取消按钮被点击
         *
         * @param v
         * @param view
         */
        public void onClickCancel(View v, DialogConfirmView view)
        {
            view.getDialoger().dismiss();
        }

        /**
         * 确定按钮被点击
         *
         * @param v
         * @param view
         */
        public void onClickConfirm(View v, DialogConfirmView view)
        {
            view.getDialoger().dismiss();
        }
    }
}
