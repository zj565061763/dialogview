package com.sd.demo.dialogview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.dialogview.DialogConfirmView;
import com.sd.lib.dialogview.DialogMenuView;
import com.sd.lib.dialogview.impl.FDialogConfirmView;
import com.sd.lib.dialogview.impl.FDialogMenuView;
import com.sd.lib.dialogview.impl.FDialogProgressView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                final FDialogConfirmView confirmView = new FDialogConfirmView(this);
                confirmView.setTextContent("content");
                confirmView.setTextContentSub("sub content");
                confirmView.setCallback(new DialogConfirmView.Callback() {
                    @Override
                    public void onClickCancel(@NotNull DialogConfirmView dialogView) {
                        super.onClickCancel(dialogView);
                        Log.i(TAG, "DialogConfirmView onClickCancel");
                    }

                    @Override
                    public void onClickConfirm(@NotNull DialogConfirmView dialogView) {
                        super.onClickConfirm(dialogView);
                        Log.i(TAG, "DialogConfirmView onClickConfirm");
                    }
                });
                confirmView.getDialog().show();
                break;
            case R.id.btn_menu:
                final FDialogMenuView menuView = new FDialogMenuView(this);
                menuView.setItems("a", "b", "c");
                menuView.setCallback(new DialogMenuView.Callback() {
                    @Override
                    public void onClickItem(int index, @NotNull DialogMenuView dialogView) {
                        super.onClickItem(index, dialogView);
                        Log.i(TAG, "DialogMenuView onClickItem index:" + index);
                    }

                    @Override
                    public void onClickCancel(@NotNull DialogMenuView dialogView) {
                        super.onClickCancel(dialogView);
                        Log.i(TAG, "DialogMenuView onClickCancel");
                    }
                });
                menuView.getDialog().show();
                break;
            case R.id.btn_progress:
                final FDialogProgressView progressView = new FDialogProgressView(this);
                progressView.getDialog().show();
                break;
        }
    }
}