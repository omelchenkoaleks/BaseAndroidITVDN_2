package com.omelchenkoaleks.baseandroiditvdn_2.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.baseandroiditvdn_2.R;

public class NotificationActivity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void showNotification(View view) {
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), ToOnActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_email)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_email))
                .setTicker("New notification")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Notification")
                .setContentText("Press that you want know a secret");

        Notification notification = builder.build();

        manager.notify(NOTIFICATION_ID, notification);
    }
}
