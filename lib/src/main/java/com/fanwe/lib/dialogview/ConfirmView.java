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

public interface ConfirmView
{
    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param layoutId
     * @return
     */
    ConfirmView setCustomView(int layoutId);

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param view
     * @return
     */
    ConfirmView setCustomView(View view);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    ConfirmView setCallback(Callback callback);

    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    ConfirmView setTextTitle(String text);

    /**
     * 设置内容文字
     *
     * @param text
     * @return
     */
    ConfirmView setTextContent(String text);

    /**
     * 设置取消按钮文字
     *
     * @param text
     * @return
     */
    ConfirmView setTextCancel(String text);

    /**
     * 设置确定按钮文字
     *
     * @param text
     * @return
     */
    ConfirmView setTextConfirm(String text);

    /**
     * 设置标题文字颜色
     *
     * @param color
     * @return
     */
    ConfirmView setTextColorTitle(int color);

    /**
     * 设置内容文字颜色
     *
     * @param color
     * @return
     */
    ConfirmView setTextColorContent(int color);

    /**
     * 设置取消文字颜色
     *
     * @param color
     * @return
     */
    ConfirmView setTextColorCancel(int color);

    /**
     * 设置确认文字颜色
     *
     * @param color
     * @return
     */
    ConfirmView setTextColorConfirm(int color);

    interface Callback
    {
        void onClickCancel(View v, ConfirmView confirmView);

        void onClickConfirm(View v, ConfirmView confirmView);
    }
}
