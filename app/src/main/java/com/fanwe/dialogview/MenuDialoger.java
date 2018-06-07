package com.fanwe.dialogview;

import android.app.Activity;
import android.view.Gravity;

import com.fanwe.lib.dialoger.animator.SlideTopBottomCreater;
import com.fanwe.lib.dialoger.impl.FDialoger;
import com.fanwe.lib.dialogview.impl.FMenuView;

public class MenuDialoger extends FDialoger
{
    private FMenuView mMenuView;

    public MenuDialoger(Activity activity)
    {
        super(activity);
        setContentView(getMenuView());
        setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        setAnimatorCreater(new SlideTopBottomCreater());
        setPadding(0, 0, 0, 0);

        getMenuView().setItems("hello", "yes", "no");
    }

    public FMenuView getMenuView()
    {
        if (mMenuView == null)
            mMenuView = new FMenuView(getContext())
            {
                @Override
                public void dismiss()
                {
                    MenuDialoger.this.dismiss();
                }
            };
        return mMenuView;
    }
}
