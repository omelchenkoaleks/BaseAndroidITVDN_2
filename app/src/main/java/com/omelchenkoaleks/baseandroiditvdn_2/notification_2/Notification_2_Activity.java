package com.omelchenkoaleks.baseandroiditvdn_2.notification_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.baseandroiditvdn_2.R;
import com.omelchenkoaleks.baseandroiditvdn_2.notification.ToOnActivity;

public class Notification_2_Activity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 127;
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_2);

        mNotificationManager = (NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotificationOnClick(View view) {
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
                .setContentText("Press that you want know a secret!")
                .setProgress(100, 50, true);

        Notification notification = builder.build();
        // можно добавить еще Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS
        notification.defaults = Notification.DEFAULT_VIBRATE;
        notification.sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.samsung);

        long[] vibrate = {1500, 1000, 1500, 1000}; // 1500 ожидание, 1000 вибро (секунда)
        notification.vibrate = vibrate;
        notification.flags = notification.flags | Notification.FLAG_INSISTENT;
        // Notification.FLAG_INSISTENT

        mNotificationManager.notify(NOTIFICATION_ID, notification);

    }

    public void cancelNotificationOnClick(View view) {
        mNotificationManager.cancel(NOTIFICATION_ID);
    }
}
