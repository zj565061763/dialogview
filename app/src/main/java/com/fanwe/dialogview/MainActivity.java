package com.fanwe.dialogview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        super.onClickCancel(v, confirmView);
                    }

                    @Override
                    public void onClickConfirm(View v, ConfirmView confirmView)
                    {
                        Toast.makeText(MainActivity.this, "confirm", Toast.LENGTH_SHORT).show();
                        super.onClickConfirm(v, confirmView);
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
                        Toast.makeText(MainActivity.this, String.valueOf(index), Toast.LENGTH_SHORT).show();
                        super.onClickItem(v, index, menuView);
                    }

                    @Override
                    public void onClickCancel(View v, MenuView menuView)
                    {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        super.onClickCancel(v, menuView);
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
