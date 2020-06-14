package com.jcy20.demo.lec06Act;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jcy20.demo.R;

public class ModeActivity extends Activity {
    private static final String TAG = "ModeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "--- onCreate: " + this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        View startBtn = findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, LifeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_start_mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, ModeActivity.class);
                startActivity(intent);
            }
        });

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
