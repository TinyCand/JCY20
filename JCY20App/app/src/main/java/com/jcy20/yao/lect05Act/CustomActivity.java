package com.jcy20.yao.lect05Act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jcy20.yao.R;

public class CustomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定Activity对应的布局
        setContentView(R.layout.layout_lect05);
        final EditText nameEdt = findViewById(R.id.edt_name);
        final EditText ageEdt = findViewById(R.id.edt_age);
        Button cmitBtn = findViewById(R.id.btn_commit);
        cmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用Intent跳转到Activity
                Intent intent = new Intent(CustomActivity.this, DisplayActivity.class);
                String nameVal = nameEdt.getText().toString().trim();
                String ageVal = ageEdt.getText().toString().trim();
                // 设置intent的附带的参数
                intent.putExtra("name", nameVal);
                intent.putExtra("age", Integer.valueOf(ageVal));
                // 跳转
                startActivity(intent);

                //复杂数据传递（传对象）
//                Boy boy = new Boy();
//                boy.setName("王源");
//                boy.setAge(24);
//                Intent complexIntent = new Intent(CustomActivity.this, DisplayActivity.class);
//                complexIntent.putExtra("user", boy);
//                startActivity(complexIntent);
            }
        });


    }
}
