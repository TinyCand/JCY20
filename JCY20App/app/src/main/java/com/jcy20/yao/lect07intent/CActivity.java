package com.jcy20.yao.lect07intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jcy20.yao.R;

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    public void toIntentAct(View view) {
        Intent intent = new Intent(CActivity.this, IntentActivity.class);
        startActivity(intent);
    }
}
