package com.jcy20.yao.lect11Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    private MyBinder mBinder = new MyBinder();

    public MyService() {

    }
    @Override
    public void onCreate() {
        Log.i(TAG, "---- onCreate");
        super.onCreate();
    }

    public void doSomething(){
        Log.i(TAG, "--- doSomething");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "--- onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "--- onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "--- onUnbind");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, "---- onDestroy");
        super.onDestroy();
    }
}
