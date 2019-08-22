package com.omelchenkoaleks.baseandroiditvdn_2.activity_lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "Lifecycle";

    private TextView mResultLifecycleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_lifecycle);

        mResultLifecycleTextView = findViewById(R.id.result_lifecycle_text_view);

        Toast.makeText(getApplicationContext(), "First: onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "First: onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "First: onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: omResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "First: onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "First: onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "First: onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "First: onDestroy()");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.touch_me_button:
                mResultLifecycleTextView.setText("Application is working");
                break;
            case R.id.second_activity_button:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            default:finish();
        }
    }
}
