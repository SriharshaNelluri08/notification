package com.example.notification;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notification = findViewById(R.id.notify_btn);
        builder1 = new AlertDialog.Builder(this);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "jrk");
                builder.setContentTitle("JRK");
                builder.setContentText("Jai Balayya...");
                builder.setSmallIcon(R.drawable.notification_icon);
                builder.setAutoCancel(true);

                NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1,builder.build());
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
//                if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                managerCompat.notify(1, builder.build());
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Jai Balayya....");
                builder1.setTitle("Alert !");
                builder1.setCancelable(false);
                builder1.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    finish();
                });
                builder1.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();
            }
        });
    }
}