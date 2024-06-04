package com.example.projekt;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class NotificationChecker extends Service {
    Timer timer;
    TimerTask task;
    String returnString="";
    int numberOfItems;
    @Override
    public void onCreate() {
        startForeground(1,showNotification("Sprawdzanie"));
        GetOrderList();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            JSONObject jsonObject = new JSONObject(returnString);
            numberOfItems = jsonObject.getJSONArray("orders").length();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        task = new TimerTask() {
            @Override
            public void run() {
                GetOrderList();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(returnString);
                    if(numberOfItems < jsonObject.getJSONArray("orders").length()){
                        numberOfItems = jsonObject.getJSONArray("orders").length();
                        updateNotification("Nowe zamówienie!");
                    }
                    else{
                        numberOfItems = jsonObject.getJSONArray("orders").length();
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer = new Timer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        ExecuteTimer();

        return START_STICKY;
    }
    private void GetOrderList(){

        SharedPreferences sharedPref = getSharedPreferences(getPackageName()+"_preferences",Context.MODE_PRIVATE);
        int userId = sharedPref.getInt("idUzytkownika",1);
        new Thread(()->{
            URL api;
            try {
                api = new URL("https://elite-anvil-425309-b6.lm.r.appspot.com/employee/"+userId);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            BufferedReader in;
            try {
                in = new BufferedReader(
                        new InputStreamReader(api.openStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String inputLine;
            while (true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) break;
//                    Log.d("APICALL", inputLine);
                    returnString = inputLine;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    private void ExecuteTimer(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(()->{
            handler.post(()->{
                timer.schedule(task,1000L,2000L);
            });

        });
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void updateNotification(String data) {
        Notification notification = showNotification(data);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
    private Notification showNotification(String content) {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            ((NotificationManager)

                    getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(

                    new NotificationChannel("100", "Foreground Notification",
                            NotificationManager.IMPORTANCE_HIGH));

        }
        return new NotificationCompat.Builder(this, "100")
                .setContentTitle("Połączenie z bazą danych")
                .setContentText(content)
                .setOnlyAlertOnce(false)
                .setOngoing(true)
                .setSmallIcon(R.drawable.baseline_forklift_24)
                .build();

    }
}
