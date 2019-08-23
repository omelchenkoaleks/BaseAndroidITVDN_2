package com.omelchenkoaleks.baseandroiditvdn_2.dialog_listeners;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class DialogListeners extends Activity {
    private static final String TAG = "DialogListeners";

    // константа для индексации диалогов = их может быть несколько
    private final int DIALOG = 1;

    // переменная общего класса Dialog для всех диалогов
    private Dialog mDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_axample);
    }

    private void run1() {
        removeDialog(DIALOG);
    }

    private void run2() {
        showDialog(DIALOG);
    }

    public void showDialogOnClick(View view) {
        showDialog(DIALOG);

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                run1();
            }
        }, 2000);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                run2();
            }
        }, 4000);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            Log.i(TAG, "Create");
            builder.setTitle("Title")
                    .setMessage("Message")
                    .setPositiveButton("OK", null);
            mDialog = builder.create();
            mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialog) {
                    Log.d(TAG, "Show");
                }
            });
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    Log.d(TAG, "Cancel");
                }
            });
            mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Log.d(TAG, "Dismiss");
                }
            });
            return mDialog;
        }
        return super.onCreateDialog(id);
    }
}
