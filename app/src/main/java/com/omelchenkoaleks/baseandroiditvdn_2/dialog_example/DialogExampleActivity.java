package com.omelchenkoaleks.baseandroiditvdn_2.dialog_example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class DialogExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_axample);
    }

    public void showDialogOnClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("my dialog")
                .setCancelable(true) // если false, просто выйти из диалога не получится
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("Exit from dialog application?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogExampleActivity.this,
                                "Application working", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
