package com.omelchenkoaleks.baseandroiditvdn_2.sample_2_second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.baseandroiditvdn_2.R;
import com.omelchenkoaleks.baseandroiditvdn_2.sample_2.FirstActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToNextActivity(View view) {
        Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
        startActivity(intent);
    }
}
