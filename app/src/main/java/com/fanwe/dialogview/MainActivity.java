package com.fanwe.dialogview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.lib.dialogview.ConfirmView;

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
                final ConfirmDialoger dialoger = new ConfirmDialoger(this);
                dialoger.getConfirmView().setCallback(new ConfirmView.Callback()
                {
                    @Override
                    public void onClickCancel(View v, ConfirmView confirmView)
                    {
                        dialoger.dismiss();
                    }

                    @Override
                    public void onClickConfirm(View v, ConfirmView confirmView)
                    {
                        dialoger.dismiss();
                    }
                });
                dialoger.show();
                break;
        }
    }
}
