package com.omelchenkoaleks.baseandroiditvdn_2.LogsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class LogActivity extends AppCompatActivity {
    private static final String TAG = "LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Log.i(TAG, "Info");
        Log.w(TAG, "Warning");
        Log.d(TAG, "Debug");
        Log.v(TAG, "Verbose");
        Log.e(TAG, "Exception", new Exception("My Exception"));
    }
}
