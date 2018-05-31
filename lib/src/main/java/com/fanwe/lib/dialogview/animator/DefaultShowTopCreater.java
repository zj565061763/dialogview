package com.fanwe.lib.dialogview.animator;

import android.animation.Animator;
import android.view.View;

public class DefaultShowTopCreater extends CombineCreater
{
    @Override
    protected Animator[] createDialogViewAnimators(boolean show, View view)
    {
        return new Animator[]{new AlphaCreater().createDialogViewAnimator(show, view)};
    }

    @Override
    protected Animator[] createContentViewAnimators(boolean show, View view)
    {
        return new Animator[]{new SlideTopTopCreater().createContentViewAnimator(show, view)};
    }
}
