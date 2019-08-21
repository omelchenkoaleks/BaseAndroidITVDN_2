package com.omelchenkoaleks.baseandroiditvdn_2.sample_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import androidx.annotation.Nullable;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class FirstActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void goToNextActivity(View view) {
        Intent intent;

        if (view.getId() == R.id.to_second_activity_button) {
            intent = new Intent("SecondActivity");
        } else {
            intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        }

        startActivity(intent);
    }
}
