package com.fanwe.dialogview;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.animator.FNodeAnimator;
import com.fanwe.lib.dialogview.DialogView;
import com.fanwe.lib.dialogview.FDialogView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_show:

                Button button = new Button(this);
                button.setText("I am a button");

                FDialogView dialogView = new FDialogView(this);
                dialogView.setContentView(button);
                dialogView.setAnimatorCreater(mScaleCreater);
                dialogView.setGrativity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                dialogView.show();

                break;
        }
    }

    private final DialogView.AnimatorCreater mScaleCreater = new DialogView.AnimatorCreater()
    {
        @Override
        public Animator createShowAnimator(DialogView dialogView)
        {
            return new FNodeAnimator(dialogView.getContentView())
                    .scaleX(0, 1).setDuration(300)
                    .withClone().scaleY(0, 1).chain().toAnimatorSet();
        }

        @Override
        public Animator createHideAnimator(DialogView dialogView)
        {
            return new FNodeAnimator(dialogView.getContentView())
                    .scaleX(1, 0).setDuration(300)
                    .withClone().scaleY(1, 0).chain().toAnimatorSet();
        }
    };
}
