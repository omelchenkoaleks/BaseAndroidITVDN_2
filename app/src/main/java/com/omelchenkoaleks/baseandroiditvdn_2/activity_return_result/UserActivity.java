package com.omelchenkoaleks.baseandroiditvdn_2.activity_return_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.omelchenkoaleks.baseandroiditvdn_2.R;
import com.omelchenkoaleks.baseandroiditvdn_2.activity_return_result.utils.RequestCode;

public class UserActivity extends AppCompatActivity {
    private TextView mNameTextView;
    private TextView mLanguageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);

        mNameTextView = findViewById(R.id.name_text_view);
        mLanguageTextView = findViewById(R.id.language_text_view);
    }

    public void settingsOnClick(View view) {
        boolean logic = view.getId() == R.id.write_name_button;
        Intent intent = (logic) ? new Intent(this, PressNameActivity.class) :
                new Intent(this, ChangeLanguageActivity.class);
        int result = (logic) ? RequestCode.NAME : RequestCode.LANGUAGE;
        startActivityForResult(intent, result);
    }

    // этот метод и получает данные с той активити, куда мы делали запрос
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RequestCode.NAME:
                    // из data получаем данные
                    assert data != null;
                    String name = data.getStringExtra("name");
                    // выводим из в TextView
                    mNameTextView.setText(String.format("%s%s", getString(R.string.confirm_your_name_message), name));
                    break;
                case RequestCode.LANGUAGE:
                    assert data != null;
                    String language = data.getStringExtra("language");
                      mLanguageTextView.setText(String.format("%s%s", getString(R.string.confirm_your_language_message), language));
                      break;
            }
        } else {
            Toast.makeText(this, "Error get data", Toast.LENGTH_SHORT).show();
        }
    }

}
