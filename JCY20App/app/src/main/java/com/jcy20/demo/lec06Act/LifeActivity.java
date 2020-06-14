package com.jcy20.demo.lec06Act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jcy20.demo.R;

public class LifeActivity extends AppCompatActivity {
    private static final String TAG = "LifeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "--- onCreate: " + this);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_life);
        View startBtn = findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeActivity.this, ModeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG, "--- onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "--- onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "--- onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "--- onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "--- onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "--- onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "--- onDestroy");
        super.onDestroy();
    }
}
