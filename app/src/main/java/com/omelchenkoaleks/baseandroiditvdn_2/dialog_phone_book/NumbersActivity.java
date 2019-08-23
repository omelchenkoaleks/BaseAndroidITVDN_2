package com.omelchenkoaleks.baseandroiditvdn_2.dialog_phone_book;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity implements Dialog.OnClickListener {
    private final int DIALOG = 1;
    private List<String> mPhones;
    private ListView mPhoneList;
    private EditText mDialogPhoneEditText;
    private EditText mDialogNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        mPhones = new ArrayList<>();
        mPhoneList = findViewById(R.id.name_number_list_view);
    }

    public void addContact(View view) {
        showDialog(DIALOG);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.view_dialog, null);
        builder.setTitle("Add Number")
                .setView(view)
                .setPositiveButton("Add", this)
                .setNegativeButton("Cancel", null);

        return builder.create();
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        if (id == DIALOG) {
            TextView dialogText = dialog.getWindow().findViewById(R.id.count_text_view);
            mDialogPhoneEditText = dialog.getWindow().findViewById(R.id.dialog_phone_edit_text);
            mDialogNameEditText = dialog.getWindow().findViewById(R.id.dialog_name_edit_text);
            dialogText.setText("Added: " + mPhones.size() + " numbers");
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String name = mDialogNameEditText.getText().toString();
        String phone = mDialogPhoneEditText.getText().toString();
        mPhones.add(name + "\n" + phone);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mPhones);
        mPhoneList.setAdapter(adapter);
    }
}
