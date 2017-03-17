package com.test.serviceplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{
  public static boolean flag = true;
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while(flag) {
            Log.e("service","服务运行中");
            Thread.sleep(5000);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    return super.onStartCommand(intent, flags, startId);
  }
}