package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

public class DefaultShowTopCreater implements DialogView.AnimatorCreater
{
    @Override
    public Animator createDialogViewAnimator(boolean show, View view)
    {
        return new AlphaCreater().createDialogViewAnimator(show, view);
    }

    @Override
    public Animator createContentViewAnimator(boolean show, View view)
    {
        return new SlideTopTopCreater().createContentViewAnimator(show, view);
    }
}
