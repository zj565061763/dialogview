package com.fanwe.dialogview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.lib.dialogview.ConfirmView;
import com.fanwe.lib.dialogview.MenuView;

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
            case R.id.btn_confirm:
                final ConfirmDialoger confirmDialoger = new ConfirmDialoger(this);
                confirmDialoger.getConfirmView().setCallback(new ConfirmView.Callback()
                {
                    @Override
                    public void onClickCancel(View v, ConfirmView confirmView)
                    {
                        confirmDialoger.dismiss();
                    }

                    @Override
                    public void onClickConfirm(View v, ConfirmView confirmView)
                    {
                        confirmDialoger.dismiss();
                    }
                });
                confirmDialoger.show();
                break;
            case R.id.btn_menu:
                final MenuDialoger menuDialoger = new MenuDialoger(this);
                menuDialoger.getMenuView().setCallback(new MenuView.Callback()
                {
                    @Override
                    public void onClickItem(View v, int index, MenuView menuView)
                    {
                        menuDialoger.dismiss();
                    }

                    @Override
                    public void onClickCancel(View v, MenuView menuView)
                    {
                        menuDialoger.dismiss();
                    }
                });
                menuDialoger.show();
                break;
            case R.id.btn_progress:
                final ProgressDialoger progressDialoger = new ProgressDialoger(this);
                progressDialoger.show();
                break;
        }
    }
}
