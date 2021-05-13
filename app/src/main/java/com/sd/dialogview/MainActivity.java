package com.sd.dialogview;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.dialoger.animator.ScaleXYCreator;
import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.DialogProgressView;
import com.sd.lib.dialogview.impl.FDialogConfirmView;
import com.sd.lib.dialogview.impl.FDialogMenuView;
import com.sd.lib.dialogview.impl.FDialogProgressView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                final DialogConfirmView confirmView = new FDialogConfirmView(this);
                confirmView.setCallback(new DialogConfirmView.Callback() {
                    @Override
                    public void onClickCancel(View v, DialogConfirmView view) {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        super.onClickCancel(v, view);
                    }

                    @Override
                    public void onClickConfirm(View v, DialogConfirmView view) {
                        Toast.makeText(MainActivity.this, "confirm", Toast.LENGTH_SHORT).show();
                        super.onClickConfirm(v, view);
                    }
                });

                confirmView.getDialoger().setAnimatorCreator(new ScaleXYCreator());
                confirmView.getDialoger().show();
                break;
            case R.id.btn_menu:

                final DialogMenuView menuView = new FDialogMenuView(this);
                menuView.setItems("0", "1", "2").setCallback(new DialogMenuView.Callback() {
                    @Override
                    public void onClickItem(View v, int index, DialogMenuView view) {
                        Toast.makeText(MainActivity.this, String.valueOf(index), Toast.LENGTH_SHORT).show();
                        super.onClickItem(v, index, view);
                    }

                    @Override
                    public void onClickCancel(View v, DialogMenuView view) {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        super.onClickCancel(v, view);
                    }
                });

                menuView.getDialoger().setPadding(0, 0, 0, 0);
                menuView.getDialoger().setGravity(Gravity.BOTTOM);
                menuView.getDialoger().show();
                break;
            case R.id.btn_progress:

                final DialogProgressView progressView = new FDialogProgressView(this);
                progressView.getDialoger().show();
                break;
        }
    }
}