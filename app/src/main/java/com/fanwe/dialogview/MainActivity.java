package com.fanwe.dialogview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.dialogview.FDialogView;
import com.fanwe.lib.dialogview.animator.ScaleXYCreater;

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
                dialogView.setAnimatorCreater(new ScaleXYCreater());
                dialogView.setGrativity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                dialogView.show();

                break;
        }
    }
}
