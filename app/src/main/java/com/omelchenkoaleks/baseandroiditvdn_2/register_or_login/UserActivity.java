package com.omelchenkoaleks.baseandroiditvdn_2.register_or_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView congratulationText;
        congratulationText = findViewById(R.id.result_text_view);

        String message = getIntent().getStringExtra("message");
        congratulationText.setText(message);
    }


    public void exitOnClick(View view) {
        finish();
    }
}
