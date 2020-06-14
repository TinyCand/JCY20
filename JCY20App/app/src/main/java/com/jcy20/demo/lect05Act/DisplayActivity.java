package com.jcy20.demo.lect05Act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jcy20.demo.R;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        // 获取其它地方传递过来的intent
        Intent intent = getIntent();
        Log.i("Display", "intent: " + intent);
        //获取intent里的附带参数(简单数据)
       String name = intent.getStringExtra("name");
       int age = intent.getIntExtra("age", -1);
//       Log.i("display", "intent extra name: "+ name + " age: "+age);


        String content =  "intent extra name: "+ name + " age: "+age;
        TextView contentTxt = findViewById(R.id.txt_content);
        contentTxt.setText(content);


        //获取intent里的附带参数(复杂数据)
//        Boy user = (Boy) intent.getSerializableExtra("user");
//        String name = user.getName();
//        Log.i("Display", "name: " + name);

    }
}
