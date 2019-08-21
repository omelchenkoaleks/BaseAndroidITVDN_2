package com.omelchenkoaleks.baseandroiditvdn_2.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class UseToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_toast);
    }

    public void showToastOnClick(View view) {
        boolean logic = view.getId() == R.id.length_short_button;
        String message = (logic) ? "Short message" : "Long message";
        int length = (logic) ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this, message, length);
        toast.show();
    }
}
