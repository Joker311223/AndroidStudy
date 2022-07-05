package com.example.myapplicationstnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                String CHANNEL_ID= "channel_1";
                String CHANNEL_NAME = "my_channel";
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                    notificationChannel.enableVibration(true);//设置振动
                    AudioAttributes audioAttributes = new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE).build();
                    notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), audioAttributes);
                    notificationManager.createNotificationChannel(notificationChannel);
                    Notification notification = new Notification.Builder(this,CHANNEL_ID)
                            .setChannelId(CHANNEL_ID)
                            .setContentTitle("This is content title")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                            .setAutoCancel(true)
                            .setStyle(new Notification.BigTextStyle()
                                    .bigText("adsfasdfadsfasdfadsfadfadsfadsfasdfadsfsdfdsfadsfadf"))
                            .setStyle(new Notification.BigPictureStyle()
                                    .bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)))
                            .setContentIntent(pi)

                            .setAutoCancel(true)
                            .build();
                    notificationManager.notify(1,notification);
                }else{
                    Notification notification = new NotificationCompat.Builder(this,"default")
                            .setContentTitle("测试notification")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher_round)
                            .setContentIntent(pi)
                            .setAutoCancel(true)
                            .build();
                    notificationManager.notify(1,notification);
                }
                break;
            default:
                break;
        }
    }
}