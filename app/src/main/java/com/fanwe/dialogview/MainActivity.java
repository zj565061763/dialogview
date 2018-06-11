package com.fanwe.dialogview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.fanwe.lib.dialoger.animator.ScaleXYCreater;
import com.fanwe.lib.dialogview.ConfirmView;
import com.fanwe.lib.dialogview.MenuView;
import com.fanwe.lib.dialogview.impl.FConfirmView;
import com.fanwe.lib.dialogview.impl.FMenuView;
import com.fanwe.lib.dialogview.impl.FProgressView;

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

                final FConfirmView confirmView = new FConfirmView(this);
                confirmView.setCallback(new ConfirmView.Callback()
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

                confirmView.getDialoger().setAnimatorCreater(new ScaleXYCreater());
                confirmView.getDialoger().show();

                break;
            case R.id.btn_menu:

                final FMenuView menuView = new FMenuView(this)
                        .setItems("0", "1", "2")
                        .setCallback(new MenuView.Callback()
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

                menuView.getDialoger().setPadding(0, 0, 0, 0);
                menuView.getDialoger().setGravity(Gravity.BOTTOM);
                menuView.getDialoger().show();

                break;
            case R.id.btn_progress:

                final FProgressView progressView = new FProgressView(this).setTextMsg("加载中...");
                progressView.getDialoger().show();

                break;
        }
    }
}
