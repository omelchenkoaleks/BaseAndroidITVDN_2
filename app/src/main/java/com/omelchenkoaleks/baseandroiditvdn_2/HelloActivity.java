package com.omelchenkoaleks.baseandroiditvdn_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        mResultTextView = findViewById(R.id.result_text_view);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);

        checkAge(name, age);
    }

    private void checkAge(String name, int age) {
        if (age >= 18) {
            mResultTextView.setText("Hello " + name + " your age: " + age);
        } else {
            mResultTextView.setText("You are don`t have 18. Go to sleep!");
        }
    }

    public void goToNextActivity(View view) {
        Intent intent = new Intent(HelloActivity.this, CheckNameActivity.class);
        startActivity(intent);
    }
}
