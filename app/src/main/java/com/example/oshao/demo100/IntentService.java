package com.example.oshao.demo100;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by oshao on 2/16/2017.
 */

public class IntentService extends Service {

    private int count = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    count++;

                    Intent intent = new Intent("flush");
                    intent.putExtra("Flush", "已经收到" + Integer.toString(count));
                    sendBroadcast(intent);

                    Log.v("IntentService", "Sending Intent" + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
