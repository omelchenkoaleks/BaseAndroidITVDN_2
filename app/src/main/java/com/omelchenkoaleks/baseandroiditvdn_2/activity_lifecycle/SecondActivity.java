package com.omelchenkoaleks.baseandroiditvdn_2.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lifecycle);

        Toast.makeText(getApplicationContext(), "Second: onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "Second: onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "Second: onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "Second: onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "Second: onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "Second: onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Second: onDestroy()");
    }

    public void onClick(View view) {
        finish();
    }
}
