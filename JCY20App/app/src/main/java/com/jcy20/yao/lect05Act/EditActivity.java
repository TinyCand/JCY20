package com.jcy20.yao.lect05Act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcy20.yao.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText nameEdt = findViewById(R.id.edt_name);
        final android.widget.EditText ageEdt = findViewById(R.id.edt_age);
        Button cmitBtn = findViewById(R.id.btn_commit);
        cmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String nameVal = nameEdt.getText().toString().trim();
                String ageVal = ageEdt.getText().toString().trim();
                // 判断字符串是否为空
                if (TextUtils.isEmpty(nameVal)) {
                    Toast.makeText(EditActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ageVal)) {
                    Toast.makeText(EditActivity.this, "请输入年龄", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 设置intent的附带的参数
                intent.putExtra("name", nameVal);

                intent.putExtra("age", Integer.valueOf(ageVal));
                setResult(RESULT_OK, intent);
                // 关闭当前Activity
                finish();

            }
        });

    }
}
