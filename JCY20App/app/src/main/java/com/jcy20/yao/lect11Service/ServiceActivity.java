package com.jcy20.yao.lect11Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.jcy20.yao.R;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";
    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TAG, "--- onServiceConnected 连接成功");
            MyService.MyBinder mBinder = (MyService.MyBinder) iBinder;
            MyService service = mBinder.getService();
            service.doSomething();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TAG, "--- onServiceDisconnected 断开连接");

        }
    };;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }

    public void startService(View view) {
        Intent intent = new Intent(ServiceActivity.this, MyService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        }
    }

    public void stopService(View view) {
        Intent intent = new Intent(ServiceActivity.this, MyService.class);
        stopService(intent);
    }

    public void bindService(View view) {
        Intent intent = new Intent(ServiceActivity.this, MyService.class);

        bindService(intent, mConn, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        if (mConn != null) {
            unbindService(mConn);
        }

    }
}
