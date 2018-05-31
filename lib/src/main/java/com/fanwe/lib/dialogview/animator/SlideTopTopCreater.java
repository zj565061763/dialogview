package com.fanwe.lib.dialogview.animator;

import android.view.View;

/**
 * 顶部滑入顶部滑出
 */
public class SlideTopTopCreater extends SlideVerticalCreater
{
    @Override
    protected float[] getValues(boolean show, View view)
    {
        return show ? new float[]{-view.getHeight(), 0} : new float[]{0, -view.getHeight()};
    }
}
