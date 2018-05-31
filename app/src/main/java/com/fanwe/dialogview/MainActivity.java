package com.fanwe.dialogview;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.dialogview.FDialogView;
import com.fanwe.lib.dialogview.animator.AlphaCreater;
import com.fanwe.lib.dialogview.animator.CombineCreater;
import com.fanwe.lib.dialogview.animator.SlideBotBotCreater;

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
                dialogView.setBackgroundColor(Color.parseColor("#77000000"));
                dialogView.setContentView(button);
                dialogView.setAnimatorCreater(new CombineCreater()
                {
                    @Override
                    protected Animator[] createDialogViewAnimators(boolean show, View view)
                    {
                        return new Animator[]{new AlphaCreater().createDialogViewAnimator(show, view)};
                    }

                    @Override
                    protected Animator[] createContentViewAnimators(boolean show, View view)
                    {
                        return new Animator[]{new SlideBotBotCreater().createContentViewAnimator(show, view)};
                    }
                });
                dialogView.setGrativity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                dialogView.show();

                break;
        }
    }
}
