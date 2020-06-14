package com.jcy20.demo.lect07intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jcy20.demo.R;

public class FlagActivity extends AppCompatActivity {

    private static final String TAG = "FlagActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "--- onCreate: " + this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        findViewById(R.id.btn_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlagActivity.this, IntentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
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
        Log.i(TAG, "--- onDestroy" + this);
        super.onDestroy();
    }

    public void toCAct(View view) {
        startActivity(new Intent(FlagActivity.this, CActivity.class));
    }
}
