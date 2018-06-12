/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.dialogview;

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
