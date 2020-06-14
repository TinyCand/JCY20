package com.jcy20.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "--- onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 从布局中根据id获取view
        Button registerBtn = findViewById(R.id.btn_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = 1;
                Log.i("MainActivity", "---- onClick "+ x);
                int t = x + 3;
                Log.i("MainActivity", "---- onClick 2"+ x);
                for (int i = 0; i < 10; i++) {
                    Log.i("MainActivity", "---- i ：" + i);
                }
            }
        });
        Log.i("MainActivity", "--- onCreate end");

    }
}
