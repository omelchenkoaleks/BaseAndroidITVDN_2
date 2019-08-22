package com.omelchenkoaleks.baseandroiditvdn_2.activity_return_result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class PressNameActivity extends AppCompatActivity {
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press_name);

        mNameEditText = findViewById(R.id.press_name_text_view);
    }

    public void confirmOnClick(View view) {
        Intent intent = new Intent();
        String name = mNameEditText.getText().toString();
        intent.putExtra("name", name);
        // благодаря этому методу мы общаемся с той активити, которая нас вызвала
        setResult(RESULT_OK, intent);
        finish();
    }

}
