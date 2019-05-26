package com.emisor.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import java.util.Random;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Intent newIntent = new Intent(context, NotificationActivity.class);

        if (action.equals("pe.edu.cibertec.broadcast.ACTION")) {
            Toast.makeText(context, "Action Ocurred", Toast.LENGTH_LONG).show();


            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, newIntent, 0);

            NotificationCompat.Builder notification = new NotificationCompat
                    .Builder(context, "Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification")
                    .setContentText("This is a new notification")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            // where id is static, the notifications will be unique and not in a queque
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(0, notification.build());
        }

        if (action.equals("android.intent.action.AIRPLANE_MODE")) {


            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, newIntent, 0);

            NotificationCompat.Builder notification = new NotificationCompat
                    .Builder(context, "Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification Airplane Mode")
                    .setContentText("Airplane Mode")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            Random random = new Random();
            int unique_id = random.nextInt(999);
            // where id is static, the notifications will be queque
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(unique_id, notification.build());
        }
    }
}
