package com.fanwe.dialogview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.dialogview.FDialogView;
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

                FDialogView dialog = new FDialogView(this);
                dialog.setBackgroundColor(Color.parseColor("#77000000"));
                dialog.setContentView(button);
                dialog.setContentAnimatorCreater(new SlideBotBotCreater());
                dialog.setGrativity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                dialog.show();

                break;
        }
    }
}
