package com.omelchenkoaleks.baseandroiditvdn_2.sample_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class CheckNameActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_name);

        mNameEditText = findViewById(R.id.name_edit_text);
        mAgeEditText = findViewById(R.id.age_edit_text);
    }

    public void goToNextActivity(View view) {
        Intent intent = new Intent(CheckNameActivity.this, HelloActivity.class);
        int age = Integer.valueOf(mAgeEditText.getText().toString());
        intent.putExtra("name", mNameEditText.getText().toString());
        intent.putExtra("age", age);
        startActivity(intent);
    }
}
