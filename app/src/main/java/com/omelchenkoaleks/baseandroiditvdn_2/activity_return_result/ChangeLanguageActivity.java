package com.omelchenkoaleks.baseandroiditvdn_2.activity_return_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class ChangeLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
    }

    public void choseOnClick(View view) {
        // получаем тот объект, на который было совершенно нажатие
        Button button = (Button) view;
        // получаем текст из названия кнопки
        String language = button.getText().toString();
        // создаем объект Интент, кладем в него данные и отправляем назад методом setResult()
        Intent intent = new Intent();
        intent.putExtra("language", language);
        setResult(RESULT_OK, intent);
        finish();
    }
}
