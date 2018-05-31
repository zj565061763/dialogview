package com.fanwe.dialogview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fanwe.lib.dialogview.DialogView;

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

                TestDialogView dialog = new TestDialogView(this);
                dialog.setOnDismissListener(new DialogView.OnDismissListener()
                {
                    @Override
                    public void onDismiss(DialogView dialogView)
                    {
                        Log.i(TAG, "onDismiss:" + dialogView);
                    }
                });
                dialog.setBackgroundColor(Color.parseColor("#77000000"));
                dialog.show();

                break;
        }
    }
}
