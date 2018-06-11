# About
封装了一些常用的窗口中用到的view

# Gradle
`implementation 'com.fanwe.android:dialogview:1.0.0-beta3'`

# 效果
![](http://thumbsnap.com/i/cjtGSvkp.gif?0606)

# ConfirmView
```java
public interface ConfirmView extends DialogView
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

    abstract class Callback
    {
        /**
         * 取消按钮被点击
         *
         * @param v
         * @param confirmView
         */
        public void onClickCancel(View v, ConfirmView confirmView)
        {
            confirmView.dismiss();
        }

        /**
         * 确定按钮被点击
         *
         * @param v
         * @param confirmView
         */
        public void onClickConfirm(View v, ConfirmView confirmView)
        {
            confirmView.dismiss();
        }
    }
}
```

# MenuView
```java
public interface MenuView extends DialogView
{
    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    MenuView setTextTitle(String text);

    /**
     * 设置取消文字
     *
     * @param text
     * @return
     */
    MenuView setTextCancel(String text);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    MenuView setCallback(Callback callback);

    /**
     * 设置列表数据
     *
     * @param objects
     * @return
     */
    MenuView setItems(Object... objects);

    /**
     * 设置列表数据
     *
     * @param listObject
     * @return
     */
    MenuView setItems(List<Object> listObject);

    /**
     * 设置适配器
     *
     * @param adapter
     * @return
     */
    MenuView setAdapter(BaseAdapter adapter);

    abstract class Callback
    {
        /**
         * item项被点击
         *
         * @param v
         * @param index
         * @param menuView
         */
        public void onClickItem(View v, int index, MenuView menuView)
        {
            menuView.dismiss();
        }

        /**
         * 取消按钮被点击
         *
         * @param v
         * @param menuView
         */
        public void onClickCancel(View v, MenuView menuView)
        {
            menuView.dismiss();
        }
    }
}
```