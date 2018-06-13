# About
封装了一些常用的窗口中用到的view

# Gradle
`implementation 'com.fanwe.android:dialogview:1.0.0-beta8'`

# 效果
![](http://thumbsnap.com/i/cjtGSvkp.gif?0606)

# DialogConfirmView
```java
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
```

# DialogMenuView
```java
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
```